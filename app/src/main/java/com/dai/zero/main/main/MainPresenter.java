package com.dai.zero.main.main;

import android.support.annotation.Nullable;

import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by dai on 2018/2/13.
 */

@ActivityScoped
public class MainPresenter implements MainContract.Presenter {


    @Nullable
    private MainContract.View mMainView;

    @Inject
    MainPresenter() {

    }

    @Override
    public void takeView(MainContract.View view) {
        this.mMainView = view;

    }

    @Override
    public void dropView() {
        mMainView = null;
    }
}
