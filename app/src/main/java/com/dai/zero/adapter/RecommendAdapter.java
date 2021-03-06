package com.dai.zero.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.dai.zero.R;
import com.dai.zero.di.GlideApp;
import com.dai.zero.main.main.find.banner.BannerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dai on 2018/4/3.
 */

public class RecommendAdapter extends BaseAdapter<String> {

    private static final String TAG = "RecommendAdapter";

    private static final int TYPE_BANNER_VIEW = -2;
    private static final int TYPE_HEADER = -1;
    private static final int TYPE_DECORATION = 0;
    private static final int TYPE_CONTENT = 1;
    private static final int TYPE_FOOTER = 2;

    private BannerView mBannerView;
    private Context context;

    private void setBannerView(BannerView mBannerView) {
        this.mBannerView = mBannerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_HEADER:
                viewHolder = new HViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_banner_view, parent, false));
                break;
            case TYPE_DECORATION:
                viewHolder = new DViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_decoration, parent, false));
                break;
            case TYPE_CONTENT:
                viewHolder = new CViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_find, parent, false));
                break;
            default:
                viewHolder = new CViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_find, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindView(final RecyclerView.ViewHolder holder, int position) {
        position = getRealPosition(position);
        if (holder instanceof CViewHolder) {
            final int index = position - (position / 7) - 1;
            ((CViewHolder) holder).itemContent.setText(data.get(index));
            GlideApp.with(context).asBitmap().load(urlList.get(index)).centerCrop()
                    .placeholder(context.getResources().getDrawable(R.mipmap.module_ic_default))
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            ((CViewHolder) holder).itemIcon.setImageBitmap(resource);
                        }
                    });
            ((CViewHolder) holder).itemIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(TYPE_CONTENT, data.get(index), index);
                }
            });
        } else if (holder instanceof DViewHolder) {
            final int index = position / 7;
            ((DViewHolder) holder).itemTitle.setText(mTitleList.get(position / 7));
            ((DViewHolder) holder).itemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(TYPE_DECORATION, mTitleList.get(index), index);

                }
            });
        } else if (holder instanceof HViewHolder) {
            ((HViewHolder) holder).bannerView.setImageViewList(imageViews);
            ((HViewHolder) holder).bannerView.execute();
            ((HViewHolder) holder).bannerView.unSubscribe();
            ((HViewHolder) holder).bannerView.subscribe();
            this.mBannerView = ((HViewHolder) holder).bannerView;
            setBannerView(((HViewHolder) holder).bannerView);
            ((HViewHolder) holder).bannerView.setOnBannerViewClickListener(new BannerView.OnBannerViewClickListener() {
                @Override
                public void OnItemClick(int position) {
                    listener.onItemClickListener(TYPE_BANNER_VIEW, null, position);
                }
            });
            ((HViewHolder) holder).moduleBtnPrivateFm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(TYPE_HEADER, null, 0);
                }
            });
            ((HViewHolder) holder).moduleBtnDailyRecommendation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(TYPE_HEADER, null, 1);
                }
            });
            ((HViewHolder) holder).moduleBtnSongSheet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(TYPE_HEADER, null, 2);
                }
            });
            ((HViewHolder) holder).moduleBtnRankingList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(TYPE_HEADER, null, 3);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return getRealItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        switch (getRealPosition(position) % 7) {
            case -1:
                return TYPE_HEADER;
            case 0:
                return TYPE_DECORATION;
            case 3:
                return TYPE_FOOTER;
            default:
                return TYPE_CONTENT;
        }
    }

    // 真实item条数
    private int getRealItemCount() {
        return getData().size() + mTitleList.size() + 1;
    }

    //当前position真实位置
    private int getRealPosition(int position) {
        return position - 1;
    }

    public BannerView getBannerView() {
        return mBannerView;
    }


    class CViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_icon)
        ImageView itemIcon;
        @BindView(R.id.item_content)
        TextView itemContent;

        CViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class DViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView itemTitle;

        DViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class HViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.banner_view)
        BannerView bannerView;
        @BindView(R.id.module_btn_private_fm)
        Button moduleBtnPrivateFm;
        @BindView(R.id.module_btn_daily_recommendation)
        Button moduleBtnDailyRecommendation;
        @BindView(R.id.module_btn_song_sheet)
        Button moduleBtnSongSheet;
        @BindView(R.id.module_btn_ranking_list)
        Button moduleBtnRankingList;

        HViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private ArrayList<String> mTitleList;
    private List<ImageView> imageViews;
    private List<String> urlList;

    public void setTitleList(ArrayList<String> mTitleList) {
        this.mTitleList = mTitleList;
    }

    public void setImageViewList(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }
}
