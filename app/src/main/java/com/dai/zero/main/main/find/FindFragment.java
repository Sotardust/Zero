package com.dai.zero.main.main.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.GlideApp;
import com.dai.zero.main.main.find.banner.BannerView;

import java.util.ArrayList;
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

    @BindView(R.id.banner_view)
    BannerView bannerView;
    Unbinder unbinder;

    @Inject
    public FindFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_find, container, false);
        unbinder = ButterKnife.bind(this, view);
        List<ImageView> imageViews = new ArrayList<>();


        ImageView imageView1 = new ImageView(getContext());
        ImageView imageView2 = new ImageView(getContext());
        ImageView imageView3 = new ImageView(getContext());
        ImageView imageView4 = new ImageView(getContext());
        ImageView imageView5 = new ImageView(getContext());
        ImageView imageView6 = new ImageView(getContext());
        ImageView imageView7 = new ImageView(getContext());
        ImageView imageView8 = new ImageView(getContext());
//        .override(100, 50)
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_1).into(imageView1).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_2).into(imageView2).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_3).into(imageView3).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_4).into(imageView4).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_5).into(imageView5).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_6).into(imageView6).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_7).into(imageView7).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_8).into(imageView8).getView());
        bannerView.setImageViewList(imageViews);
        bannerView.setOnImageViewClickListener(new BannerView.OnImageViewClickListener() {
            @Override
            public void OnClick(int position) {
                Log.d(TAG, "OnClick() called with: position = [" + position + "]");

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        bannerView.start();
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
}
