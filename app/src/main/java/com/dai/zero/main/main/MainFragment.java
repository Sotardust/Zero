package com.dai.zero.main.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.adapter.BaseFragmentPageAdapter;
import com.dai.zero.adapter.MainAdapter;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.main.main.find.FindFragment;
import com.dai.zero.main.main.mine.MineFragment;
import com.dai.zero.main.main.transceiver.TransceiverFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dai on 2018/2/13.
 */
@ActivityScoped
public class MainFragment extends BaseFragment implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "MainFragment";

    @Inject
    MainContract.Presenter mPresenter;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    Unbinder unbinder;

    private String[] titles = {"发现", "我的", "电台", "我的", "电台", "我的"};

    @Inject
    FindFragment findFragment;

    @Inject
    MineFragment mineFragment;

    @Inject
    TransceiverFragment transceiverFragment;

    @Inject
    public MainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.module_fragment_main, container, false);
        unbinder = ButterKnife.bind(this, root);
        bindViews();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    @Override
    public void onRefresh() {
//        mPresenter.onRefresh();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }


    @Override
    public void bindViews() {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
//        recyclerView.setLayoutManager(layoutManager);
//        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light);
//        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
//        swipeRefreshLayout.setOnRefreshListener(this);
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(findFragment);
        mFragmentList.add(mineFragment);
        mFragmentList.add(transceiverFragment);


//        BaseFragmentPageAdapter adapter = new BaseFragmentPageAdapter(getChildFragmentManager(),mFragmentList);

        viewPager.setAdapter(new BaseFragmentPageAdapter(getChildFragmentManager(), mFragmentList, titles));
        viewPager.setCurrentItem(0);

//        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d(TAG, "onPageScrolled() returned: " + position);
            }

            @Override
            public void onPageSelected(int position) {

                Log.d(TAG, "onPageSelected() called with: position = [" + position + "]");

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void setAdapter(MainAdapter adapter) {
//        recyclerView.setAdapter(adapter);
    }

    @Override
    public Object getObject() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
