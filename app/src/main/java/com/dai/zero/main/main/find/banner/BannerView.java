package com.dai.zero.main.main.find.banner;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dai.zero.R;

import java.util.List;

/**
 * Created by dai on 2018/3/19.
 */

public class BannerView extends RelativeLayout {

    private static final String TAG = "BannerView";

    //装载ImageView控件的list
    private List<ImageView> ivList;
    //圆点指示器控件
    private List<View> DotViewList;
    //控制圆点View的形状，未选中的颜色
    private GradientDrawable gradientDrawable;
    //控制圆点View的形状，选中的颜色
    private GradientDrawable gradientDrawableSelected;

    //自动轮播的时间间隔(s)
    private int intervalTime = 5;

    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "BannerView() called with: context = [" + context + "], attrs = [" + attrs + "]");
        init(context, attrs);
    }

    public void setImageViewList(List<ImageView> ivList) {
        System.out.println("ivList.size() = " + ivList.size());
        this.ivList = ivList;
    }

    public void setDotViewList(List<View> DotViewList) {
        this.DotViewList = DotViewList;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    private View view;
    private ViewPager viewPager;
    private LinearLayout dotBanner;
    private Context context;

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.module_view_banner, this, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        dotBanner = (LinearLayout) view.findViewById(R.id.dot_banner);

    }

    public void setData() {
        for (int i = 0; i < ivList.size(); i++) {
            ImageView dotView = new ImageView(context);
            if (i != 0) {
                dotView.setBackgroundResource(R.mipmap.banner_grey);
            } else {
                dotView.setBackgroundResource(R.mipmap.banner_red);
            }
            viewPager.addView(ivList.get(i));
            dotBanner.addView(dotView, i);
        }
        viewPager.addOnPageChangeListener(new onPageChangerListener());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
    }

    private class onPageChangerListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Log.d(TAG, "onPageSelected() called with: position = [" + position + "]");
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = ivList.get(position);
            ViewParent vp = imageView.getParent();
            if (vp != null) {
                ViewGroup parent = (ViewGroup) vp;
                parent.removeView(imageView);
            }
            container.addView(imageView);
            return imageView;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
//            return ivList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }


//    public static class Builder {
//
//        private Context context;
//
//        //装载ImageView控件的list
//        private List<ImageView> ivList;
//        //圆点指示器控件
//        private List<View> vList;
//        //控制圆点View的形状，未选中的颜色
//        private GradientDrawable gradientDrawable;
//        //控制圆点View的形状，选中的颜色
//        private GradientDrawable gradientDrawableSelected;
//
//        //自动轮播的时间间隔(s)
//        private int intervalTime = 5;
//
//        public Builder(Context context) {
//            this.context = context;
//        }
//
//        public Builder setIntervalTime(int intervalTime) {
//            this.intervalTime = intervalTime;
//            return this;
//        }
//
//        public BannerView build() {
//
//            return new BannerView(context);
//        }
//    }
}
