package com.dai.zero.main.leftmain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dai on 2018/2/13.
 */
@ActivityScoped
public class LeftMainFragment extends BaseFragment implements LeftMainContract.View {

    @Inject
    LeftMainContract.Presenter mPresenter;
    Unbinder unbinder;

    @Inject
    public LeftMainFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.module_fragment_leftmain, container, false);
        unbinder = ButterKnife.bind(this, root);
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

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
