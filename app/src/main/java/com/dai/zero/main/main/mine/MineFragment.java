package com.dai.zero.main.main.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.adapter.MainAdapter;
import com.dai.zero.di.ActivityScoped;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dai on 2018/3/19.
 */

@ActivityScoped
public class MineFragment extends BaseFragment implements MineContract.View {

    private static final String TAG = "MineFragment";

    @BindView(R.id.module_recycle_mine)
    RecyclerView recyclerView;
    Unbinder unbinder;

    @Inject
    MinePresenter presenter;

    @Inject
    public MineFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
        presenter.traversalSong();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.takeView(this);
        unbinder.unbind();
    }


    @Override
    public void bindView() {

    }

    @Override
    public void showRecyclerView(ArrayList<File> files) {

        MainAdapter adapter = new MainAdapter();
        ArrayList<String> names = new ArrayList<>();
        for (File file : files) {
            names.add(file.getName());
        }
        adapter.setData(names);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
