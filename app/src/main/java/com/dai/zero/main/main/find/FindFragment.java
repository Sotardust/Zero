package com.dai.zero.main.main.find;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_1).into(new ImageView(getContext())).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_2).into(new ImageView(getContext())).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_3).into(new ImageView(getContext())).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_4).into(new ImageView(getContext())).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_5).into(new ImageView(getContext())).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_6).into(new ImageView(getContext())).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_7).into(new ImageView(getContext())).getView());
        imageViews.add(GlideApp.with(this).load(R.mipmap.acg_8).into(new ImageView(getContext())).getView());
        bannerView.setImageViewList(imageViews);
        bannerView.start();
        bannerView.setOnBannerViewClickListener(new BannerView.OnBannerViewClickListener() {
            @Override
            public void OnItemClick(int position) {

            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
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
}
