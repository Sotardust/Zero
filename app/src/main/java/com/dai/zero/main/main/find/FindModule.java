package com.dai.zero.main.main.find;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dai on 2018/3/19.
 */

@Module
public abstract class FindModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract FindFragment findFragment();

    @ActivityScoped
    @Binds
    abstract FindContract.Presenter findPresenter(FindPresenter presenter);
}
