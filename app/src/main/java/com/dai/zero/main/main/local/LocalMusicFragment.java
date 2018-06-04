package com.dai.zero.main.main.local;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.adapter.MainAdapter;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.util.listener.RecycleItemClickListener;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

@ActivityScoped
public class LocalMusicFragment extends BaseFragment implements LocalMusicContract.View {

    private static final String TAG = "LocalMusicFragment";
    @BindView(R.id.module_recycle_local_music)
    RecyclerView recyclerView;
    Unbinder unbinder;
    @Inject
    LocalMusicPresenter presenter;

    @Inject
    public LocalMusicFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_fragment_local_music, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void bindViews() {

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
        presenter.traversalSong();
    }

    @Override
    public void showRecyclerView(final ArrayList<File> files) {
        MainAdapter adapter = new MainAdapter();
        ArrayList<String> names = new ArrayList<>();
        for (File file : files) {
            names.add(file.getName());
        }
        adapter.setData(names);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setRecycleItemClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClickListener(int type, String value, int position) {
                super.onItemClickListener(type, value, position);
                String path = files.get(position).getPath();
                Log.d(TAG, "onItemClickListener: path " + path);
                presenter.playMusic(getContext(), path);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.dropView();
    }
}
