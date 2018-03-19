package com.dai.zero.main.main.mine;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dai on 2018/3/19.
 */

@Module
public abstract class MineModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MineFragment mineFragment();

    @ActivityScoped
    @Binds
    abstract MineContract.Presenter minePresenter(MinePresenter presenter);

}
