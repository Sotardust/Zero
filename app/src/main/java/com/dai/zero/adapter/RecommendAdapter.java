package com.dai.zero.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dai.zero.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dai on 2018/4/3.
 */

public class RecommendAdapter extends BaseAdapter<String> {

    private static final String TAG = "RecommendAdapter";

    @Override
    public RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_find, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, final int position, final String value) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).itemContent.setText(value);
            if (position!=0) ((ViewHolder) holder).itemLlTitle.setVisibility(View.GONE);
            ((ViewHolder) holder).itemTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick() returned: " + value);
                }
            });
            ((ViewHolder) holder).itemIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick() returned: " + position);
                }
            });
        }

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView itemTitle;
        @BindView(R.id.item_ll_title)
        LinearLayout itemLlTitle;
        @BindView(R.id.item_icon)
        ImageView itemIcon;
        @BindView(R.id.item_content)
        TextView itemContent;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
