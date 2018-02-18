package com.dai.zero.main.Leftmain;

import android.support.annotation.Nullable;

import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by dai on 2018/2/13.
 */

@ActivityScoped
public class LeftMainPresenter implements LeftMainContract.Presenter {


    @Nullable
    private LeftMainContract.View mLeftMainView;

    @Inject
    LeftMainPresenter() {

    }

    @Override
    public void takeView(LeftMainContract.View view) {
        this.mLeftMainView = view;

    }

    @Override
    public void dropView() {
        mLeftMainView = null;
    }
}
