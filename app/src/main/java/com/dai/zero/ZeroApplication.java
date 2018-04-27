package com.dai.zero;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.dai.zero.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * We create a custom {@link Application} class that extends  {@link DaggerApplication}.
 * We then override applicationInjector() which tells Dagger how to make our @Singleton Component
 * We never have to call `component.inject(this)` as {@link DaggerApplication} will do that for us.
 */
public class ZeroApplication extends DaggerApplication {

    private static final String TAG = "ZeroApplication";

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        Log.d(TAG, "applicationInjector: ");
        return DaggerAppComponent.builder().application(this).build();
    }

    private  RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        refWatcher = LeakCanary.install(this);
//       LeakCanary.install(this);
    }

    public static RefWatcher getInstance(Context context) {

        ZeroApplication application = (ZeroApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
