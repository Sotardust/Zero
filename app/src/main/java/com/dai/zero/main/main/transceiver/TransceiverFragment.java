package com.dai.zero.main.main.transceiver;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Inject
    public TransceiverFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_transceiver, container, false);
        Log.d(TAG, "onCreateView: ");
        unbinder = ButterKnife.bind(this, view);
        mPresenter.getNoSleep();
        mPresenter.getSleepTwo();
        mPresenter.getSleepThree();
        mPresenter.getSleepFive();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.takeView(this);
//        bannerView.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
//        bannerView.stop();
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

}
