package com.dai.zero.adapter;

import android.support.v7.widget.RecyclerView;
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
 * Created by Administrator on 2018/6/26 0026.
 */

public class LocalMusicAdapter extends BaseAdapter<String> {

    private ArrayList<String> usernameList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateView(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.module_recycle_item_local_music, parent, false));
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).songName.setText(data.get(position));
            ((ViewHolder) holder).songName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(Type.TV.ordinal(), data.get(position), position);
                }
            });
            ((ViewHolder) holder).username.setText(usernameList.get(position));
            ((ViewHolder) holder).more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(Type.IV.ordinal(), null, position);
                }
            });
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_song_name)
        TextView songName;
        @BindView(R.id.tv_username)
        TextView username;
        @BindView(R.id.iv_more)
        ImageView more;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setUsernameList(ArrayList<String> usernameList) {
        this.usernameList = usernameList;
    }

    enum Type {
        TV(0), IV(1);

        Type(int i) {
        }
    }

}
