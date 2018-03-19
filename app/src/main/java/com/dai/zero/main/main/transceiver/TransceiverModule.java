package com.dai.zero.main.main.transceiver;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by dai on 2018/3/19.
 */

@Module
public abstract class TransceiverModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract TransceiverFragment transceiverFragment();

    @ActivityScoped
    @Binds
    abstract TransceiverContract.Presenter transceiverPresenter(TransceiverPresenter presenter);
}
