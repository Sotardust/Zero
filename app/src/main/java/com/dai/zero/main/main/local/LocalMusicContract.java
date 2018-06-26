package com.dai.zero.main.main.local;

import android.content.Context;

import com.dai.zero.BasePresenter;
import com.dai.zero.BaseView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

public interface LocalMusicContract {
    interface View extends BaseView<Presenter> {
        void bindViews();

        void showRecyclerView(ArrayList<File> files);
    }

    interface Presenter extends BasePresenter<View> {
        void traversalSong();

        void playMusic(Context context, String path);

        String parseSongName(String path);

        String parseUsername(String path);
    }
}
