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
 * Created by Administrator on 2018/6/3 0003.
 */

public class MineAdapter extends BaseAdapter<String> {


    @Override
    public RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_mine, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).content.setText(data.get(position));
            ((ViewHolder) holder).content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(0, data.get(position), position);
                }
            });
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.module_tv_content)
        TextView content;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
