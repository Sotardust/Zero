package com.dai.zero.main.main.find;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.adapter.RecommendAdapter;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.GlideApp;
import com.dai.zero.main.util.MyItemDecoration;
import com.dai.zero.util.listener.RecycleItemClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class FindFragment extends BaseFragment implements FindContract.View {

    private static final String TAG = "FindFragment";

    @Inject
    FindContract.Presenter mPresenter;

    Unbinder unbinder;
    //    @BindView(R.id.banner_view)
//    BannerView bannerView;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.load_image)
    ImageView loadImage;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;

    private View view;
    private AnimationDrawable animationDrawable;
    private boolean isFirstVisible = false;
    private boolean isVisibleToUser = false;

    private RecommendAdapter adapter;

    @Inject
    public FindFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.module_fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        isFirstVisible = true;
        if (isVisibleToUser()) {
            onFragmentFirstVisible();
        }
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        mPresenter.takeView(this);
        System.out.println("isVisibleToUser = " + isVisibleToUser());
        System.out.println("adapter != null = " + (adapter != null));
        System.out.println("adapter.getBannerView() != null = " + (adapter.getBannerView() != null));
        if (isVisibleToUser() && adapter != null && adapter.getBannerView() != null) {
            Log.d(TAG, "onResume11: ");
//            adapter.getBannerView().onResume();
        }
        isFirstVisible = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (isVisibleToUser() && adapter != null && adapter.getBannerView() != null) {
            adapter.getBannerView().stop();
            Log.d(TAG, "onPause: ");
        }
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        unbinder.unbind();
        mPresenter.dropView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void bindViews() {

        List<ImageView> imageViews = new ArrayList<>();

        String[] urls = getResources().getStringArray(R.array.module_url_banner_picture);

        for (String url : urls) {
            ImageView imageView = new ImageView(getContext());
            imageViews.add(GlideApp.with(this).load(url).centerCrop().into(imageView).getView());
        }


        adapter = new RecommendAdapter();
        String[] mTitle = getContext().getResources().getStringArray(R.array.module_recommend_title);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < mTitle.length * 6; i++) {
            list.add("数据" + i);
        }
        ArrayList<String> mTitleList = new ArrayList<>();
        Collections.addAll(mTitleList, mTitle);

        adapter.setData(list);
        adapter.setTitleList(mTitleList);
        adapter.setImageViewList(imageViews);
        if (isVisibleToUser() && adapter != null && adapter.getBannerView() != null) {
            Log.d(TAG, "onResume11 start : ");
            adapter.getBannerView().start();
        }


        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        MyItemDecoration decoration = new MyItemDecoration();
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = adapter.getItemViewType(position);
                return type <= 0 ? 3 : 1;
            }
        });


        recycleView.addItemDecoration(decoration);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(adapter);

        adapter.setRecycleItemClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClickListener(int type, String value, int position) {
                Toast.makeText(getContext(), value, Toast.LENGTH_SHORT).show();
                switch (type) {
                    case -2:
                        Log.d(TAG, "BANNER_VIEW() returned: " + position);
                        break;
                    case -1:
                        Log.d(TAG, "BANNER_VIEW() returned: " + position);
                        break;
                    case 0:
                        Log.d(TAG, "onItemClickListener() returned: " + 0);
                        break;
                    case 1:
                        Log.d(TAG, "onItemClickListener() returned: " + 1);
                        break;
                    case 2:
                        Log.d(TAG, "onItemClickListener() returned: " + 2);
                        break;
                    case 3:
                        Log.d(TAG, "onItemClickListener() returned: " + 3);
                        break;
                }
            }
        });


    }

    @Override
    public void showTestView1(String string) {

    }

    @Override
    public void showTestView2(String string) {

    }

    @Override
    public void showTestView3(String string) {

    }

    @Override
    public void showTestView4(String string) {

    }

    @Override
    public void showLoading() {
        if (isFirstVisible()) {
            llLoad.setVisibility(View.VISIBLE);
            loadImage = (ImageView) view.findViewById(R.id.load_image);
            loadImage.setImageResource(R.drawable.module_load_anim);
            animationDrawable = (AnimationDrawable) loadImage.getDrawable();
            animationDrawable.start();
        }

    }

    @Override
    public void hideLoading() {
        if (isFirstVisible()) {
            animationDrawable.stop();
            llLoad.setVisibility(View.GONE);
            isFirstVisible = false;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser && isFirstVisible()) {
            onFragmentFirstVisible();
        }
    }

    private void onFragmentFirstVisible() {
        bindViews();
//        mPresenter.getNeteaseData();
//        mPresenter.getNoSleep();
//        mPresenter.getSleepTwo();
//        mPresenter.getSleepThree();
//        mPresenter.getSleepFive();
    }

    public boolean isFirstVisible() {
        return isFirstVisible;
    }

    public boolean isVisibleToUser() {
        return isVisibleToUser;
    }

}
