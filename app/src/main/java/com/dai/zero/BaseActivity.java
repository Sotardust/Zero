package com.dai.zero;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.os.IResultReceiver;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by dai on 2018/2/13.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";
    // 管理运行的所有的activity
    private final  List<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("BaseActivity.onCreate");
        synchronized (mActivities) {
        mActivities.add(this);
//            Intent intent = new Intent();
//            Intent.Flag
        }
    }

    //添加Activity

    private List<BaseActivity> getActivities() {
        return mActivities;
    }

    private void deleteActivity(BaseActivity activity) {

        System.out.println("activity = " + activity);
        if (mActivities.contains(activity)) {
            mActivities.remove(activity);
        }
    }

    protected void exit() {
        mActivities.clear();
        Log.d(TAG, "exit() returned: " + mActivities.size());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        deleteActivity(this);
//        ZeroApplication.getInstance(getApplicationContext()).watch(this);
    }
}
