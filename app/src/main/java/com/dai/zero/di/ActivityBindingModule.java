package com.dai.zero.di;

import com.dai.zero.main.leftmain.LeftMainModule;
import com.dai.zero.main.MainActivity;
import com.dai.zero.main.main.MainModule;
import com.dai.zero.main.main.find.FindModule;
import com.dai.zero.main.main.mine.MineModule;
import com.dai.zero.main.main.local.LocalMusicActivity;
import com.dai.zero.main.main.local.LocalMusicModule;
import com.dai.zero.main.main.transceiver.TransceiverModule;
import com.dai.zero.main.rightmain.RightMainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * We want Dagger.Android to create a Subcomponent which has a parent Component of whichever module ActivityBindingModule is on,
 * in our case that will be AppComponent. The beautiful part about this setup is that you never need to tell AppComponent that it is going to have all these subcomponents
 * nor do you need to tell these subcomponents that AppComponent exists.
 * We are also telling Dagger.Android that this generated SubComponent needs to include the specified modules and be aware of a scope annotation @ActivityScoped
 * When Dagger.Android annotation processor runs it will create 4 subcomponents for us.
 */
@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            LeftMainModule.class,
            MainModule.class,
            RightMainModule.class,
            FindModule.class,
            MineModule.class,
            TransceiverModule.class})
    abstract MainActivity mainActivity();

//    @ActivityScoped
//    @ContributesAndroidInjector(modules = {FindModule.class, MineModule.class, TransceiverModule.class})
//    abstract MainFragment MainFragment();

    @ActivityScoped
    @ContributesAndroidInjector(modules = LocalMusicModule.class)
    abstract LocalMusicActivity localMusicActivity();
}
