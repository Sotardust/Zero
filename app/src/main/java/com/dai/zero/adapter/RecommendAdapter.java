package com.dai.zero.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dai.zero.R;
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

    public void setmBannerView(BannerView mBannerView) {
        this.mBannerView = mBannerView;
    }

    private BannerView mBannerView;

    @Override
    public RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_HEADER:
//                viewHolder = new HViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_banner_view, parent, false));
//                break;
            case TYPE_DECORATION:
                viewHolder = new DViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_decoration, parent, false));
                break;
            case TYPE_CONTENT:
                viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_find, parent, false));
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, int position) {
        position = getRealPosition(position);
        if (holder instanceof ViewHolder) {
            final int index = position - (position / 7) - 1;
            ((ViewHolder) holder).itemContent.setText(data.get(index));
            ((ViewHolder) holder).itemIcon.setOnClickListener(new View.OnClickListener() {
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
            ((HViewHolder) holder).bannerView.start();
            this.mBannerView = ((HViewHolder) holder).bannerView;
            setmBannerView(((HViewHolder) holder).bannerView);
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
    public int getRealPosition(int position) {
        return position - 1;
    }

    public BannerView getBannerView() {
        return mBannerView;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_icon)
        ImageView itemIcon;
        @BindView(R.id.item_content)
        TextView itemContent;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    static class DViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView itemTitle;

        DViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class HViewHolder extends RecyclerView.ViewHolder {
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

    public void setTitleList(ArrayList<String> mTitleList) {
        this.mTitleList = mTitleList;
    }

    public void setImageViewList(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }
}
