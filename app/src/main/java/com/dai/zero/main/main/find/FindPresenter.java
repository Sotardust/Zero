package com.dai.zero.main.main.find;

import android.util.Log;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.http.okhttp.OkHttpUtil;
import com.dai.zero.main.util.ParamAnalysisUtil;
import com.dai.zero.util.inter.ObserverListener;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class FindPresenter implements FindContract.Presenter {

    private static final String TAG = "FindPresenter";
    private FindContract.View mFindView;

    @Inject
    FindPresenter() {
    }

    @Override
    public void takeView(FindContract.View view) {
        this.mFindView = view;
    }

    @Override
    public void dropView() {
        mFindView = null;
    }

    @Override
    public void getNeteaseData() {

        String url = "http://39.106.220.113:8080/mobile/params";
        String params = "{\"ids\":\"[426027293]\",\"br\":128000,\"csrf_token\":\"\"}";
        final HashMap<String, String> param = new HashMap<>();
        param.put("param", params);

        OkHttpUtil.postRequest(url, param, new ObserverListener<String>() {
            @Override
            public void onNext(final String s) {
                super.onNext(s);
                String url = "http://music.163.com/weapi/song/enhance/player/url?csrf_token=";
                OkHttpUtil.postRequest(url, ParamAnalysisUtil.stringToHashMap(s), new ObserverListener<String>() {
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
}
