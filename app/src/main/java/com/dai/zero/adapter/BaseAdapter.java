package com.dai.zero.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<T> data;

    private OnItemClickLister<T> onItemClickLister;

    public void setOnItemClickLister(OnItemClickLister<T> onItemClickLister) {
        this.onItemClickLister = onItemClickLister;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateView(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final T value = data.get(position);
        if (onItemClickLister != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickLister.onItemClick(position, value);
                }
            });
        }
        onBindView(holder, position, value);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ArrayList<T> getData() {
        return data;
    }

    public abstract RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType);

    public abstract void onBindView(RecyclerView.ViewHolder holder, int position, T value);

    public interface OnItemClickLister<T> {
        void onItemClick(int position, T data);
    }
}
