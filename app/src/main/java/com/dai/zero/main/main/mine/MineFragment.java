package com.dai.zero.main.main.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dai.zero.BaseFragment;
import com.dai.zero.R;
import com.dai.zero.adapter.MineAdapter;
import com.dai.zero.di.ActivityScoped;
import com.dai.zero.main.main.local.LocalMusicActivity;
import com.dai.zero.util.listener.RecycleItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;

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
        showRecyclerView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.dropView();
        unbinder.unbind();
    }


    @Override
    public void bindView() {

    }

    @Override
    public void showRecyclerView() {

        MineAdapter adapter = new MineAdapter();
        String[] datas = getContext().getResources().getStringArray(R.array.module_mine_content);
        ArrayList<String> names = new ArrayList<>();
        names.addAll(Arrays.asList(datas));
        System.out.println("names = " + names);
        adapter.setData(names);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setRecycleItemClickListener(new RecycleItemClickListener() {
            @Override
            public void onItemClickListener(int type, String value, int position) {
                super.onItemClickListener(type, value, position);
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getContext(), LocalMusicActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                    case 2:
                        Toast.makeText(getContext(), value, Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }
}
