package com.dai.zero.main.main.find;

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

    @Inject
    public FindFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        bindViews();
        mPresenter.getNeteaseData();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        bannerView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerView.stop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
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
        });


    }
}
