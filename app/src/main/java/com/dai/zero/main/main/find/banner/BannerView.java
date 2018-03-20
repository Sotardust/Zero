package com.dai.zero.main.main.find.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.dai.zero.R;
import com.dai.zero.di.GlideApp;
import com.dai.zero.main.util.ConvertUtil;
import com.dai.zero.util.inter.ObserverListener;
import com.dai.zero.util.inter.onPageChangerListener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dai on 2018/3/19.
 */

public class BannerView extends RelativeLayout {

    private static final String TAG = "BannerView";
    //装载ImageView控件的list
    private List<ImageView> imageViews;
    //viewPager的当前页下标
    private int currentIndex = 0;
    private ViewPager viewPager;
    private LinearLayout ll;
    private Context context;
    private LinearLayout.LayoutParams lp;
    private Observable<Long> observable;
    //默认自动轮播的时间间隔(s)
    private int intervalTime = 2;


    private OnImageViewClickListener onImageViewClickListener;

    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void setImageViewList(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public void setOnImageViewClickListener(OnImageViewClickListener onImageViewClickListener) {
        this.onImageViewClickListener = onImageViewClickListener;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Float x = 0f, y = 0f;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                Log.d(TAG, "onTouch() returned: " + event.getX());
                Log.d(TAG, "onTouch() returned: " + event.getY());
                observable.unsubscribeOn(Schedulers.io());
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("(Math.abs(y - event.getY()) = " + (Math.abs(x - event.getX())));
                Log.d(TAG, "onTouch() returned: " + event.getX());
                if (Math.abs(x - event.getX()) < 50) {
                    onImageViewClickListener.OnClick(currentIndex);
                }
                observable.subscribe();
                break;
        }
        return super.onTouchEvent(event);
    }

    //适配viewpager 设置自动轮播

    public void start() {
        for (int i = 0; i < imageViews.size(); i++) {
            fillData(i, 0);
            viewPager.addView(imageViews.get(i));
        }
        viewPager.addOnPageChangeListener(new onPageChangerListener() {
            @Override
            public void onPageSelected(int position) {
                position = getCurrentIndex(position);
                ll.removeAllViews();
                for (int i = 0; i < imageViews.size(); i++) {
                    fillData(i, position);
                }
            }
        });
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        observable = Observable.interval(intervalTime, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new ObserverListener<Long>() {
            @Override
            public void onNext(Long aLong) {
                super.onNext(aLong);
                boolean flag = currentIndex != 0;
                viewPager.setCurrentItem(currentIndex, flag);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.e(TAG, "onError: ", e);
            }
        });
        observable.subscribe();
    }

    //停止图片轮换取消订阅
    public void stop() {
        observable.unsubscribeOn(Schedulers.io());
    }

    //初始化视图
    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        lp = new LinearLayout.LayoutParams(ConvertUtil.dip2px(context, 8), ConvertUtil.dip2px(context, 8));
        LayoutInflater.from(context).inflate(R.layout.module_view_banner, this, true);
        viewPager = (ViewPager) findViewById(R.id.vp_banner);
        ll = (LinearLayout) findViewById(R.id.dot_banner);
    }

    //获取取余获取viewpager当前坐标
    private int getCurrentIndex(int index) {
        if (index > imageViews.size() - 1) {
            index = index % imageViews.size();
        }
        return index;
    }

    //填充数据
    private void fillData(int index, int position) {
        ImageView dotView = new ImageView(context);
        dotView.setScaleType(ImageView.ScaleType.CENTER);
        dotView.setLayoutParams(lp);
        @DrawableRes int resId = index == position ? R.mipmap.banner_red : R.mipmap.banner_grey;
        ll.addView(GlideApp.with(context).load(resId).into(dotView).getView());

    }


    private class ViewPagerAdapter extends PagerAdapter {

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            currentIndex = getCurrentIndex(position);
            ImageView imageView = imageViews.get(currentIndex);
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
            return imageViews.size() * 100;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }

    public interface OnImageViewClickListener {
        void OnClick(int position);
    }

}
