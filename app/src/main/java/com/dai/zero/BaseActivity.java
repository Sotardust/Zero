package com.dai.zero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by dai on 2018/2/13.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity {

    // 管理运行的所有的activity
    public final static List<AppCompatActivity> mActivities = new LinkedList<AppCompatActivity>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("BaseActivity.onCreate");
        synchronized (mActivities) {
            mActivities.add(this);
        }
    }
}
