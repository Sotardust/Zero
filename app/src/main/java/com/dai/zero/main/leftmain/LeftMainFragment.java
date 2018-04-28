package com.dai.zero.main.leftmain;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.di.ActivityScoped;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dai on 2018/2/13.
 */
@ActivityScoped
public class LeftMainFragment extends BaseFragment implements LeftMainContract.View {

    @Inject
    LeftMainContract.Presenter mPresenter;
    @BindView(R.id.btn)
    Button btn;
    Unbinder unbinder;
    @BindView(R.id.btn1)
    Button btn1;

    @Inject
    public LeftMainFragment() {

    }

    private final static List<String> mActivities = new LinkedList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.module_fragment_leftmain, container, false);
        mActivities.add("添加");


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

    void startAsyncTask() {
        new AsyncTask<Void, Void, Void>() {//1
            @Override
            protected Void doInBackground(Void... params) {
                while (true) ;
            }
        }.execute();
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        startAsyncTask();

    }

    private static Object inner;

    void createInnerClass() {
        class InnerClass {
        }
        inner = new InnerClass();//1
    }

    @OnClick(R.id.btn1)
    public void onViewClicked1() {
        createInnerClass();
    }
}
