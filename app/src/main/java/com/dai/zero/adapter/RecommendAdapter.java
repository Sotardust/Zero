package com.dai.zero.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dai.zero.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dai on 2018/4/3.
 */

public class RecommendAdapter extends BaseAdapter<String> {

    private static final String TAG = "RecommendAdapter";

    private static final int TYPE_HEADER = -1;
    private static final int TYPE_DECORATION = 0;
    private static final int TYPE_CONTENT = 1;
    private static final int TYPE_FOOTER = 2;


    @Override
    public RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateView() called with: viewType = [" + viewType + "]");
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case -1:
                break;
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
    public void onBindView(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            final int index = position - (position / 7);
            ((ViewHolder) holder).itemContent.setText(data.get(index));
            ((ViewHolder) holder).itemIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(data.get(index), index);
                }
            });
        } else if (holder instanceof DViewHolder) {
            final int index = position / 7;
            ((DViewHolder) holder).itemTitle.setText(mTitleList.get(position / 7));
            ((DViewHolder) holder).itemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(mTitleList.get(index), index);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return getData().size() + mTitleList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_icon)
        ImageView itemIcon;
        @BindView(R.id.item_content)
        TextView itemContent;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (position % 7) {
            case -1:
//                return TYPE_HEADER;
            case 0:
                return TYPE_DECORATION;
            case 100:
                return TYPE_FOOTER;
            default:
                return TYPE_CONTENT;

        }

    }

    class DViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView itemTitle;

        DViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private ArrayList<String> mTitleList;

    public void setTitleList(ArrayList<String> mTitleList) {
        this.mTitleList = mTitleList;
    }
}
