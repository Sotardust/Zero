package com.dai.zero.main.rightmain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

/**
 * Created by dai on 2018/2/13.
 */
@ActivityScoped
public class RightMainFragment extends BaseFragment implements RightMainContract.View {

    @Inject
    RightMainContract.Presenter mPresenter;

    @Inject
    public RightMainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rightmain, container, false);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }
}
