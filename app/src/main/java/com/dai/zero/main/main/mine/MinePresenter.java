package com.dai.zero.main.main.mine;

import android.os.Environment;
import android.util.Log;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.util.LogUtil;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class MinePresenter implements MineContract.Presenter {

    private static final String TAG = "MinePresenter";
    private MineContract.View mMineView;


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
}
