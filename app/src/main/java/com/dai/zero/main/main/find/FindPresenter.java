package com.dai.zero.main.main.find;

import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class FindPresenter implements FindContract.Presenter {

    private static final String TAG = "FindPresenter";
    private FindContract.View mFindView;

    @Inject
    public FindPresenter() {
    }

    @Override
    public void takeView(FindContract.View view) {
        this.mFindView = view;
    }

    @Override
    public void dropView() {
        mFindView = null;
    }
}
