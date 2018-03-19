package com.dai.zero.main.main;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.dai.zero.adapter.MainAdapter;
import com.dai.zero.di.ActivityScoped;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dai on 2018/2/13.
 */

@ActivityScoped
public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";
    @Nullable
    private MainContract.View mMainView;
    private MainAdapter adapter = new MainAdapter();

    @Inject
    MainPresenter() {
    }

    @Override
    public void takeView(MainContract.View view) {
        this.mMainView = view;
        setData();
    }

    @Override
    public void dropView() {
        mMainView = null;
    }

    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void setData() {
        for (int i = 0; i < 20; i++) {
            list.add("当前时第" + i + "item");
        }
        assert mMainView != null;
        adapter.setList(list);
        mMainView.setAdapter(adapter);

    }

    private int count = 0;

    @Override
    public void onRefresh() {


        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                list.add("当前时第" + (20 + count++) + "item");
                list.add("当前时第" + (20 + count++) + "item");
                list.add("当前时第" + (20 + count++) + "item");
                list.add("当前时第" + (20 + count++) + "item");
                list.add("当前时第" + (20 + count++) + "item");

                adapter.setList(list);
                adapter.notifyDataSetChanged();
                emitter.onNext("onRefresh");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.d(TAG, "accept: " + s);
                        Log.d(TAG, "accept() called with: s = [" + s + "]");
                        Log.i(TAG, "accept: " + s);
                        Log.d(TAG, "accept() returned: " + s);
                        Log.w(TAG, "accept: w" + s);
                        Log.e(TAG, "accept: e" + s);
                        assert mMainView != null;
                        ((SwipeRefreshLayout) mMainView.getObject()).setRefreshing(false);
                    }
                });
    }
}
