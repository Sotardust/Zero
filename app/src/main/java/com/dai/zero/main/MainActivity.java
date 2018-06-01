package com.dai.zero.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dai.zero.BaseActivity;
import com.dai.zero.MyViewPager;
import com.dai.zero.R;
import com.dai.zero.adapter.BaseFragmentPageAdapter;
import com.dai.zero.main.leftmain.LeftMainFragment;
import com.dai.zero.main.main.MainFragment;
import com.dai.zero.main.rightmain.RightMainFragment;
import com.dai.zero.util.FileUtil;
import com.dai.zero.util.callback.OnPageChangerCallback;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dai on 2018/2/12.
 */

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.iv_title_menu)
    ImageView ivTitleMenu;
    @BindView(R.id.main_pager)
    RadioButton rbHomePager;
    @BindView(R.id.left_pager)
    RadioButton rbMusicPager;
    @BindView(R.id.right_pager)
    RadioButton rbFriendPager;
    @BindView(R.id.rg_home_viewpager_contorl)
    RadioGroup rgHomeViewpagerControl;
    @BindView(R.id.contentFrame)
    MyViewPager contentFrame;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Inject
    MainFragment mainFragment;
    @Inject
    LeftMainFragment leftMainFragment;
    @Inject
    RightMainFragment rightMainFragment;

    //    @Inject
//    Lazy<MainFragment> mainFragmentProvider;
    private static final int REQUEST_CODE = 1;
    private static final String[] requestPermissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_main);
        ButterKnife.bind(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, requestPermissions, REQUEST_CODE);
        }
//        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.contentFrame);
//        if (mainFragment == null) {
//            // Get the fragment from dagger
//            mainFragment = mainFragmentProvider.get();
//            System.out.println("mainFragment = " + mainFragment);
//        }

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(leftMainFragment);
        mFragmentList.add(mainFragment);
        mFragmentList.add(rightMainFragment);
        contentFrame.setAdapter(new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        contentFrame.setCurrentItem(1);
        contentFrame.addOnPageChangeListener(new OnPageChangerCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        rgHomeViewpagerControl.check(R.id.main_pager);
                        break;
                    case 1:
                        rgHomeViewpagerControl.check(R.id.left_pager);
                        break;
                    case 2:
                        rgHomeViewpagerControl.check(R.id.right_pager);
                        break;
                }
            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 按返回键不退出应用。
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                // 不退出程序，进入后台
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @OnClick({R.id.iv_title_menu, R.id.main_pager, R.id.left_pager, R.id.right_pager, R.id.textView})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_title_menu:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.main_pager:
                contentFrame.setCurrentItem(0);
                break;
            case R.id.left_pager:
                contentFrame.setCurrentItem(1);
                break;
            case R.id.right_pager:
                contentFrame.setCurrentItem(2);
                break;
            case R.id.textView:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            FileUtil fileUtil = new FileUtil();
            fileUtil.createDirectory();
            fileUtil.createLogFile();
        }
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        // activity 都不可见的情况下，进程保活
        Log.d(TAG, "onTrimMemory: ");
    }

}
