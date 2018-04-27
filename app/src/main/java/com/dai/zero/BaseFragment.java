package com.dai.zero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.DaggerFragment;

/**
 * Created by dai on 2018/2/13.
 */

public abstract class BaseFragment extends DaggerFragment {

    private static final String TAG = "BaseFragment";

    protected View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("BaseFragment.onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        ZeroApplication.getInstance(getContext()).watch(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        Log.d(TAG, "onDestroyView: ");
//        ZeroApplication.getInstance(getContext()).watch(this);

    }
}
