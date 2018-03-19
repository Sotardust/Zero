package com.dai.zero.main.main.mine;

import com.dai.zero.di.ActivityScoped;

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
