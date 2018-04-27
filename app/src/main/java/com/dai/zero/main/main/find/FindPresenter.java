package com.dai.zero.main.main.find;

import android.util.Log;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.http.okhttp.OkHttpUtil;
import com.dai.zero.http.url.TestUrl;
import com.dai.zero.main.util.ParamAnalysisUtil;
import com.dai.zero.util.callback.ObserverCallback;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class FindPresenter implements FindContract.Presenter {

    private static final String TAG = "FindPresenter";
//    private FindContract.View mFindView;

    @Inject
    FindPresenter() {
    }

    private WeakReference<FindContract.View> mFindView;

    @Override
    public void takeView(FindContract.View view) {

        this.mFindView = new WeakReference<FindContract.View>(view);
//        mFindView.get().showLoading();
    }

    @Override
    public void dropView() {
        mFindView = null;
//        for (Disposable disposable : disposeList) {
//            if (disposable != null && !disposable.isDisposed())
//                disposable.dispose();
//        }
//        if (disposeList.size() != 0) disposeList.clear();
    }

//    private ArrayList<Disposable> disposeList = new ArrayList<>();



    @Override
    public void getNeteaseData() {

        String url = "http://39.106.220.113:8080/mobile/params";
        String params = "{\"ids\":\"[426027293]\",\"br\":128000,\"csrf_token\":\"\"}";
        final HashMap<String, String> param = new HashMap<>();
        param.put("param", params);

        OkHttpUtil.postRequest(url, param, new ObserverCallback<String>() {
            @Override
            public void onNext(final String s) {
                super.onNext(s);
                String url = "http://music.163.com/weapi/song/enhance/player/url?csrf_token=";
                OkHttpUtil.postRequest(url, ParamAnalysisUtil.stringToHashMap(s), new ObserverCallback<String>() {
                    @Override
                    public void onNext(String s) {
                        super.onNext(s);
                        Log.d(TAG, "onNext() returned: " + s);
                    }
                });

            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void getNoSleep() {
        OkHttpUtil.getRequest(TestUrl.NO_SLEEP, new ObserverCallback<String>() {
            @Override
            public void onNext(String s) {
                super.onNext(s);
                Log.d(TAG, "onNext() returned: " + s);
                if (mFindView != null)
                    mFindView.get().showTestView1(s);

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
                if (mFindView != null)
                    mFindView.get().showTestView2(s);
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
                if (mFindView != null)
                    mFindView.get().showTestView3(s);
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
                if (mFindView != null) {
                    mFindView.get().showTestView4(s);
//                    mFindView.get().hideLoading();
                }
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
