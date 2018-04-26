package com.dai.zero.main.main.find;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.adapter.RecommendAdapter;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.GlideApp;
import com.dai.zero.main.main.find.banner.BannerView;
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
    @BindView(R.id.banner_view)
    BannerView bannerView;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.show_1)
    TextView show1;
    @BindView(R.id.show_2)
    TextView show2;
    @BindView(R.id.show_3)
    TextView show3;
    @BindView(R.id.show_4)
    TextView show4;


    ImageView loadImage;
    AnimationDrawable animationDrawable;

    View view;

    @Inject
    public FindFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.module_fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        bindViews();
        mPresenter.getNeteaseData();
        mPresenter.getNoSleep();
        mPresenter.getSleepTwo();
        mPresenter.getSleepThree();
        mPresenter.getSleepFive();
        Log.d(TAG, "onCreateView: ");
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        bannerView.onResume();

        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerView.stop();
        Log.d(TAG, "onPause: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        mPresenter.dropView();
        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void bindViews() {

        List<ImageView> imageViews = new ArrayList<>();

        String[] urls = getResources().getStringArray(R.array.module_url_banner_picture);

        for (String url : urls) {
            ImageView imageView = new ImageView(getContext());
            imageViews.add(GlideApp.with(this).load(url).centerCrop().into(imageView).getView());
        }
        bannerView.setImageViewList(imageViews);
        bannerView.start();
        bannerView.setOnBannerViewClickListener(new BannerView.OnBannerViewClickListener() {
            @Override
            public void OnItemClick(int position) {

            }
        });

        final RecommendAdapter adapter = new RecommendAdapter();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            list.add("数据" + i);
        }
        String[] mTitle = getContext().getResources().getStringArray(R.array.module_recommend_title);
        ArrayList<String> mTitleList = new ArrayList<>();
        Collections.addAll(mTitleList, mTitle);
        adapter.setData(list);
        adapter.setTitleList(mTitleList);
        final GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        MyItemDecoration decoration = new MyItemDecoration();
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = adapter.getItemViewType(position % 7);
//                int count = type ==0?3:1;
                return type == 0 ? 3 : 1;
            }
        });


        recycleView.addItemDecoration(decoration);
        recycleView.setLayoutManager(layoutManager);

        recycleView.setAdapter(adapter);
        adapter.setRecycleItemClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClickListener(String value, int position) {

                System.out.println("value = " + value);
                System.out.println("position = " + position);
                Log.d(TAG, "onItemClickListener() called with: value = [" + value + "], position = [" + position + "]");

            }

            @Override
            public void onItemLongClickListener(String value, int position) {
                super.onItemLongClickListener(value, position);
            }
        });


    }

    @Override
    public void showTestView1(String string) {
        show1.setText(string);
    }

    @Override
    public void showTestView2(String string) {
        show2.setText(string);
    }

    @Override
    public void showTestView3(String string) {
        show3.setText(string);
    }

    @Override
    public void showTestView4(String string) {
        show4.setText(string);
    }

    @Override
    public void showLoading() {
//        loading.inflate();
        loadImage = (ImageView) view.findViewById(R.id.load_image);
        loadImage.setImageResource(R.drawable.module_load_anim);
        animationDrawable = (AnimationDrawable) loadImage.getDrawable();
        animationDrawable.start();

    }

    @Override
    public void hideLoading() {
//        loading.setVisibility(View.GONE);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d(TAG, "onHiddenChanged: " + hidden);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: " + isVisibleToUser);
    }
}
