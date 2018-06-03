package com.dai.zero.main.main.mine.local;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import com.dai.zero.BuildConfig;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.util.FileType;
import com.dai.zero.util.LogUtil;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

@ActivityScoped
public class LocalMusicPresenter implements LocalMusicContract.Presenter {

    private static final String TAG = "LocalMusicPresenter";
    private LocalMusicContract.View localMusicView;
    private ArrayList<File> filePaths = new ArrayList<>();

    @Inject
    public LocalMusicPresenter() {
    }

    @Override
    public void takeView(LocalMusicContract.View view) {
        this.localMusicView = view;
    }

    @Override
    public void dropView() {
        localMusicView = null;
    }


    @Override
    public void traversalSong() {

        //模拟器地址
//        String path = Environment.getExternalStorageDirectory() + File.separator + "Music";
        //手机地址
        String path = Environment.getExternalStorageDirectory() + File.separator + "netease";
        File file = new File(path);
        if (!file.exists()) {
            LogUtil.writeInfo(TAG, "traversalSong", path + "路径不存在");
            Log.d(TAG, "searchSong: " + path + "路径不存在");
            return;
        }
        if (!filePaths.isEmpty()) filePaths.clear();
        searchSongFile(path);
        localMusicView.showRecyclerView(filePaths);
    }

    @Override
    public void playMusic(Context context, String path) {
        if (context == null || path == null) return;
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //设置intent的Action属性
        intent.setAction(Intent.ACTION_VIEW);
        //文件的类型
        String type = "";
        for (String[] array : FileType.MATCH_ARRAY) {
            //判断文件的格式
            if (path.contains(array[0])) {
                type = array[1];
                break;
            }
        }
        try {
            File file = new File(path);
            //判断是否是AndroidN以及更高的版本,设置intent的data和Type属性
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", file);
                intent.setDataAndType(contentUri, type);
            } else {
                intent.setDataAndType(Uri.fromFile(file), type);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "无法打开该文件", Toast.LENGTH_SHORT).show();
            LogUtil.writeErrorInfo(TAG, "playMusic", "无法打开该文件");
            Log.e(TAG, "playMusic: e", e);
            e.printStackTrace();
        }
    }

    /**
     * 遍历查找歌曲文件
     *
     * @param path 路径
     */
    private void searchSongFile(String path) {
        File file1 = new File(path);
        File[] files = file1.listFiles();
        System.out.println("files.length = " + files.length);
        for (File file : files) {
            if (file.isFile() && (file.getName().contains(".mp3") && !file.getName().contains(".mp3.") || file.getName().contains(".flac"))) {
                Log.d(TAG, "findSong: " + file.getPath());
                filePaths.add(file);

            } else if (file.isDirectory())
                searchSongFile(file.getPath());
        }
    }
}
