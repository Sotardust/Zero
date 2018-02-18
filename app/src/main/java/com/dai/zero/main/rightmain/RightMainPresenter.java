package com.dai.zero.main.rightmain;

import android.support.annotation.Nullable;

import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by dai on 2018/2/13.
 */

@ActivityScoped
public class RightMainPresenter implements RightMainContract.Presenter {


    @Nullable
    private RightMainContract.View mRightMainView;

    @Inject
    RightMainPresenter() {

    }

    @Override
    public void takeView(RightMainContract.View view) {
        this.mRightMainView = view;

    }

    @Override
    public void dropView() {
        mRightMainView = null;
    }
}
