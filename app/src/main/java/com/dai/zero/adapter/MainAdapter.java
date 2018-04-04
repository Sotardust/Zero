package com.dai.zero.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dai.zero.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dai on 2018/2/24.
 */

public class MainAdapter extends BaseAdapter<String> {

    @Override
    public RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).itemContent.setText(data.get(position));
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_content)
        TextView itemContent;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
