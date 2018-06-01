package com.dai.zero.main.main.transceiver;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.di.ActivityScoped;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class TransceiverFragment extends BaseFragment implements TransceiverContract.View {

    private static final String TAG = "TransceiverFragment";

    @Inject
    TransceiverContract.Presenter mPresenter;
    @BindView(R.id.text_1)
    TextView text1;
    Unbinder unbinder;
    @BindView(R.id.show_1)
    TextView show1;
    @BindView(R.id.show_2)
    TextView show2;
    @BindView(R.id.show_3)
    TextView show3;
    @BindView(R.id.show_4)
    TextView show4;
    @BindView(R.id.load_image)
    ImageView loadImage;
    @BindView(R.id.ll_load)
    LinearLayout llLoad;

    private View view;
    private AnimationDrawable animationDrawable;
    private boolean isFirstVisible = false;
    private boolean isVisibleToUser = false;

    @Inject
    public TransceiverFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.module_fragment_transceiver, container, false);
        Log.d(TAG, "onCreateView: ");
        unbinder = ButterKnife.bind(this, view);
        isFirstVisible = true;

//        if (isVisibleToUser()) {
//            onFragmentFirstVisible();
//        }
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
        isFirstVisible = false;
    }

    @Override
    public void onPause() {
        super.onPause();
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
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        if (isVisibleToUser && isFirstVisible()) {
            onFragmentFirstVisible();
        }
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
            animationDrawable = null;
        }
    }

    private void onFragmentFirstVisible() {

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
