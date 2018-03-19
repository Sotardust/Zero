package com.dai.zero.main.main.transceiver;

import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class TransceiverPresenter implements TransceiverContract.Presenter {

    private static final String TAG = "TransceiverPresenter";

    private TransceiverContract.View mTransceiverView;

    @Inject
    public TransceiverPresenter() {
    }

    @Override
    public void takeView(TransceiverContract.View view) {
        this.mTransceiverView = view;
    }

    @Override
    public void dropView() {
        mTransceiverView = null;
    }
}
