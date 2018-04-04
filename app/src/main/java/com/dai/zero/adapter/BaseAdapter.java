package com.dai.zero.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.dai.zero.util.listener.RecycleItemClickListener;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/2 0002.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    protected ArrayList<T> data;

    protected OnItemClickLister<T> onItemClickLister;

    public void setOnItemClickLister(OnItemClickLister<T> onItemClickLister) {
        this.onItemClickLister = onItemClickLister;
    }

    protected RecycleItemClickListener listener;

    public void setRecycleItemClickListener(RecycleItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateView(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

//        if (onItemClickLister != null) {
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onItemClickLister.onItemClick(position, value);
//                }
//            });
//        }

        onBindView(holder, position);
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

    public abstract void onBindView(RecyclerView.ViewHolder holder, int position);

    public interface OnItemClickLister<T> {
        void onItemClick(int position, T data);
    }
}
