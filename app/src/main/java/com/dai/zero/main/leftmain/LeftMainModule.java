package com.dai.zero.main.leftmain;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dai on 2018/2/13.
 */

@Module
public abstract class LeftMainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LeftMainFragment leftMainFragment();

    @ActivityScoped
    @Binds
    abstract LeftMainContract.Presenter leftMainPresenter(LeftMainPresenter presenter);

}
