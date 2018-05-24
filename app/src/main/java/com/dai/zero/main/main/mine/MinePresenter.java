package com.dai.zero.main.main.mine;

import android.os.Environment;
import android.util.Log;

import com.dai.zero.di.ActivityScoped;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class MinePresenter implements MineContract.Presenter {

    private static final String TAG = "MinePresenter";
    private MineContract.View mMineView;
    private ArrayList<File> filePaths = new ArrayList<>();

    @Inject
    public MinePresenter() {
    }

    @Override
    public void takeView(MineContract.View view) {
        this.mMineView = view;
    }

    @Override
    public void dropView() {
        mMineView = null;
    }

    @Override
    public void searchSong() {
//        String path = Environment.getRootDirectory().getAbsolutePath() + "/netease";
        String path =  "/storage/sdcard0/netease";
        System.out.println("path = " + path);
//        /storage/sdcard0/netease
        File file = new File(path);
        if (!file.exists()) {
            Log.d(TAG, "searchSong: " + path + "路径不存在");
            return;
        }
        if (!filePaths.isEmpty()) filePaths.clear();
        findSong(path);

        mMineView.showRecyclerView(filePaths);

    }

    /**
     * 遍历查找歌曲文件
     *
     * @param path 路径
     */
    private void findSong(String path) {
        File file1 = new File(path);
        File[] files = file1.listFiles();
        System.out.println("files.length = " + files.length);
        for (File file : files) {
            if (file.isFile() && (file.getName().contains(".mp3") || file.getName().contains(".flac"))) {
                Log.d(TAG, "findSong: " + file.getPath());
                filePaths.add(file);

            } else if (file.isDirectory())
                findSong(file.getPath());
        }
    }
}
