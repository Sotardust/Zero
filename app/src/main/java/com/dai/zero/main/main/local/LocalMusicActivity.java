package com.dai.zero.main.main.local;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dai.zero.BaseActivity;
import com.dai.zero.R;
import com.dai.zero.util.ActivityUtils;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/6/3 0003.
 */

public class LocalMusicActivity extends BaseActivity {

    @Inject
    LocalMusicFragment localMusicFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_local_music);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), localMusicFragment, R.id.module_fl_frameLayout);
//        if (localMusicFragment == null) {
//            // Get the fragment from dagger
//            localMusicFragment = mainFragmentProvider.get();
//            System.out.println("mainFragment = " + mainFragment);
//        }
    }
}
