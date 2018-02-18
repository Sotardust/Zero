package com.dai.zero.main.rightmain;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dai on 2018/2/13.
 */

@Module
public abstract class RightMainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract RightMainFragment rightMainFragment();

    @ActivityScoped
    @Binds
    abstract RightMainContract.Presenter rightMainPresenter(RightMainPresenter presenter);

}
