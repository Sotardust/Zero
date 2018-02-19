package com.dai.zero.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.dai.zero.BaseActivity;
import com.dai.zero.R;
import com.dai.zero.adapter.MainFragmentPageAdapter;
import com.dai.zero.main.Leftmain.LeftMainFragment;
import com.dai.zero.main.main.MainFragment;
import com.dai.zero.main.rightmain.RightMainFragment;
import com.dai.zero.util.ActivityUtils;

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

    @BindView(R.id.fl_title_menu)
    FrameLayout flTitleMenu;
    @BindView(R.id.rg_home_viewpager_contorl)
    RadioGroup rgHomeViewpagerContorl;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.contentFrame)
    ViewPager contentFrame;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

//    @Inject
//    Lazy<MainFragment> mainFragmentProvider;

    @Inject
    MainFragment mainFragment;
    @Inject
    LeftMainFragment leftMainFragment;
    @Inject
    RightMainFragment rightMainFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.contentFrame);
//        if (mainFragment == null) {
//            // Get the fragment from dagger
//            mainFragment = mainFragmentProvider.get();
//            System.out.println("mainFragment = " + mainFragment);
//        }

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(leftMainFragment);
        mFragmentList.add(mainFragment);
        mFragmentList.add(rightMainFragment);
        contentFrame.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
        contentFrame.setCurrentItem(1);
        contentFrame.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rgHomeViewpagerContorl.check(R.id.rb_home_pager);
                        break;
                    case 1:
                        rgHomeViewpagerContorl.check(R.id.rb_music_pager);
                        break;
                    case 2:
                        rgHomeViewpagerContorl.check(R.id.rb_friend_pager);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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

    @OnClick({R.id.fl_title_menu, R.id.rg_home_viewpager_contorl, R.id.toolbar, R.id.contentFrame, R.id.drawerLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_title_menu:
                System.out.println("MainActivity.onViewClicked fl_title_menu ");
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.rg_home_viewpager_contorl:
                rgHomeViewpagerContorl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {

                        switch (i) {
                            case R.id.rb_home_pager:
                                contentFrame.setCurrentItem(0);// 设置当前页面
//                        vpContent.setCurrentItem(0,false);// false去掉viewpager切换页面的动画
                                break;
                            case R.id.rb_music_pager:
                                contentFrame.setCurrentItem(1);
                                break;
                            case R.id.rb_friend_pager:
                                contentFrame.setCurrentItem(2);
                                break;
                        }
                    }
                });
                break;
            case R.id.toolbar:
                break;
            case R.id.contentFrame:
                break;
            case R.id.drawerLayout:

                break;
        }
    }
}
