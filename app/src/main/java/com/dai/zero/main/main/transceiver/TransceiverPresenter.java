package com.dai.zero.main.main.transceiver;

import android.util.Log;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.http.okhttp.OkHttpUtil;
import com.dai.zero.http.url.TestUrl;
import com.dai.zero.util.callback.ObserverCallback;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class TransceiverPresenter implements TransceiverContract.Presenter {

    private static final String TAG = "TransceiverPresenter";

    private WeakReference<TransceiverContract.View> mTransceiverView;

    @Inject
    public TransceiverPresenter() {
    }

    @Override
    public void takeView(TransceiverContract.View view) {
        this.mTransceiverView = new WeakReference<TransceiverContract.View>(view);
    }

    @Override
    public void dropView() {
        mTransceiverView = null;
        for (Disposable disposable : disposeList) {
            if (disposable != null && !disposable.isDisposed())
                disposable.dispose();
        }
        if (disposeList.size() != 0) disposeList.clear();
    }

    private ArrayList<Disposable> disposeList = new ArrayList<>();


    @Override
    public void getNoSleep() {
        OkHttpUtil.getRequest(TestUrl.NO_SLEEP, new ObserverCallback<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
                Log.d(TAG, "onNext() returned: " + s);
                if (mTransceiverView != null)
                    mTransceiverView.get().showTestView1(s);
            }

            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
//                disposeList.add(d);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);

                e.printStackTrace();
            }
        });
    }

    @Override
    public void getSleepTwo() {
        OkHttpUtil.getRequest(TestUrl.SLEEP_TWO, new ObserverCallback<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
                Log.d(TAG, "onNext() returned: " + s);
                if (mTransceiverView != null)
                    mTransceiverView.get().showTestView2(s);

            }

            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
//                disposeList.add(d);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                e.printStackTrace();
            }
        });


    }

    @Override
    public void getSleepThree() {
        OkHttpUtil.getRequest(TestUrl.SLEEP_THREE, new ObserverCallback<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
                Log.d(TAG, "onNext() returned: " + s);
                if (mTransceiverView != null)
                    mTransceiverView.get().showTestView3(s);
            }

            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
//                disposeList.add(d);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                e.printStackTrace();
            }
        });

    }

    @Override
    public void getSleepFive() {
        OkHttpUtil.getRequest(TestUrl.SLEEP_FIVE, new ObserverCallback<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
                Log.d(TAG, "onNext() returned: " + s);
                System.out.println("(mTransceiverView != null) = " + (mTransceiverView != null));
                if (mTransceiverView != null)
                    mTransceiverView.get().showTestView4(s);
            }

            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
//                disposeList.add(d);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                e.printStackTrace();
            }
        });

    }
}
