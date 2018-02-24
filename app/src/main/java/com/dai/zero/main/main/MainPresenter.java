package com.dai.zero.main.main;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.dai.zero.adapter.MainAdapter;
import com.dai.zero.di.ActivityScoped;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by dai on 2018/2/13.
 */

@ActivityScoped
public class MainPresenter implements MainContract.Presenter {


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

        list.add("当前时第" + (20 + count++) + "item");
        list.add("当前时第" + (20 + count++) + "item");
        list.add("当前时第" + (20 + count++) + "item");
        list.add("当前时第" + (20 + count++) + "item");
        list.add("当前时第" + (20 + count++) + "item");

        adapter.setList(list);
        adapter.notifyDataSetChanged();
        assert mMainView != null;
        ((SwipeRefreshLayout) mMainView.getObject()).setRefreshing(false);
    }
}
