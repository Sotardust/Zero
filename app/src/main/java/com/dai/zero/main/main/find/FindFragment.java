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
        for (int i = 0; i < 6; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.mipmap.ic_launcher);
            imageViews.add(imageView);
        }
        bannerView.setImageViewList(imageViews);
        bannerView.setData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
