package com.dai.zero.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/2/19.
 */

//public class BaseFragmentPageAdapter extends FragmentPagerAdapter {
public class BaseFragmentPageAdapter extends FragmentStatePagerAdapter {
//    FragmentStatePagerAdapter

    private List<Fragment> fragmentList;
    private String[] mTitleList;

    public BaseFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public BaseFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] mTitleList){
        super(fm);
        this.fragmentList = fragmentList;
        this.mTitleList = mTitleList;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList != null) {
            return mTitleList[position];
        } else {
            return "";
        }
    }
}
