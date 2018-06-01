package com.dai.zero.util;

import android.os.Environment;
import android.util.Log;

import com.dai.zero.BuildConfig;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dai on 2018/6/1.
 */

public class FileUtil {

    private static final String TAG = "FileUtil";

    private static final String PATH = Environment.getExternalStorageDirectory()
            + File.separator + BuildConfig.APPLICATION_ID + File.separator;

    //音乐文件路径
    public static final String musicPath = PATH + "Music" + File.separator;

    //日志路径
    public static final String logPath = PATH + "log" + File.separator;

    private ArrayList<String> directoryList = new ArrayList<>();

    //日志文件名称
    public static final String logFile = "log.txt";

    public FileUtil() {

    }

    //创建文件目录
    public void createDirectory() {
        directoryList.add(musicPath);
        directoryList.add(logPath);
        for (String path : directoryList) {
            File directory = new File(path);
            if (!directory.exists()) {
                boolean isSuccessful = directory.mkdirs();
                Log.d(TAG, "createDirectory: isSuccessful" + isSuccessful);
            }
        }
    }

    //创建日志文件log.txt
    public void createLogFile() {
        try {
            File file = new File(logPath + logFile);
            if (!file.exists()) {
                boolean isSuccessful = file.createNewFile();
                Log.d(TAG, "createLogFile: isSuccessful" + isSuccessful);
            }
        } catch (IOException e) {
            Log.d(TAG, "createLogFile: e = " + e);
        }
    }

    //创建新文件
    public static File createNewFile(String path) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                boolean isSuccessful = file.createNewFile();
                Log.d(TAG, "createNewFile: " + path + (isSuccessful ? "成功" : "失败"));
            }
        } catch (IOException e) {
            LogUtil.writeErrorInfo(TAG, "createNewFile", e.toString());
            e.printStackTrace();
        }

        return file;
    }

}
