package com.dai.zero.main.main.mine.local;

import com.dai.zero.di.ActivityScoped;
import com.dai.zero.di.FragmentScoped;
import com.dai.zero.main.main.mine.MinePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

@Module
public abstract class LocalMusicModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract LocalMusicFragment localMusicFragment();

    @ActivityScoped
    @Binds
    abstract LocalMusicContract.Presenter localMusicPresenter(LocalMusicPresenter presenter);

}
