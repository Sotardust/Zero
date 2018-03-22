package com.dai.zero.main.main.find.banner;

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
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dai on 2018/3/19.
 */

public class BannerView extends RelativeLayout {

    private static final String TAG = "BannerView";
    private static final int MAX_VALUE = 1000;

    //默认自动轮播的时间间隔(s)
    private int intervalTime = 2;
    //用于判断左右滑动
    private boolean isMove = true;
    //装载ImageView控件的list
    private List<ImageView> imageViews;
    //viewPager的循环页下标初始值设置为1000
    private int loopIndex = 1000;

    private ViewPager viewPager;
    private LinearLayout ll;
    private Context context;
    private LinearLayout.LayoutParams lp;
    private Observable<Long> observable;
    private ObserverListener<Long> observerListener;
    private Disposable disposable;

    private OnBannerViewClickListener onBannerViewClickListener;

    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setImageViewList(List<ImageView> imageViews) {
        this.imageViews = imageViews;
    }

    public void setIntervalTime(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    public void setOnBannerViewClickListener(OnBannerViewClickListener onBannerViewClickListener) {
        this.onBannerViewClickListener = onBannerViewClickListener;
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isMove = false;
                unSubscribe();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isMove) {
                    isMove = true;
                    subscribe();
                }
                break;
            case MotionEvent.ACTION_UP:
                isMove = false;
                //对bannerView点击事件进行监听
                onBannerViewClickListener.OnItemClick(getCurrentIndex(loopIndex));
                subscribe();
                break;
            default:
                break;
        }
        return onTouchEvent(event);
    }

    //适配viewpager设置自动轮播
    public void start() {
        for (int i = 0; i < imageViews.size(); i++) {
            fillData(i, 0);
            viewPager.addView(imageViews.get(i));
        }
        viewPager.addOnPageChangeListener(new onPageChangerListener() {
            @Override
            public void onPageSelected(int position) {
                //手动滑动时对ViewPager循环索引赋值
                loopIndex = position;
                ll.removeAllViews();
                for (int i = 0; i < imageViews.size(); i++) {
                    fillData(i, getCurrentIndex(position));
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1000);
        observerListener = new ObserverListener<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);

                //用于设置取消订阅
                disposable = d;
            }

            @Override
            public void onNext(Long o) {
                super.onNext(o);
                loopIndex++;
                viewPager.setCurrentItem(loopIndex);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.e(TAG, "onError: ", e);
            }
        };
        observable = Observable.interval(intervalTime, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    //重新开始图片轮播
    public void onResume() {
        subscribe();
    }

    //停止图片轮播取消订阅
    public void stop() {
        unSubscribe();
    }

    //订阅图片轮播事件
    private void subscribe() {
        observable.subscribe(observerListener);
    }

    //取消订阅图片轮播事件
    private void unSubscribe() {
        observable.unsubscribeOn(Schedulers.io());
        if (disposable != null && !disposable.isDisposed())
            disposable.dispose();
    }


    //初始化视图
    private void init(Context context) {
        this.context = context;
        lp = new LinearLayout.LayoutParams(ConvertUtil.dip2px(context, 8), ConvertUtil.dip2px(context, 8));
        LayoutInflater.from(context).inflate(R.layout.module_view_banner, this, true);
        viewPager = (ViewPager) findViewById(R.id.vp_banner);
        ll = (LinearLayout) findViewById(R.id.dot_banner);
    }

    //通过取余获取viewpager当前坐标
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
            ImageView imageView = imageViews.get(getCurrentIndex(position));
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
            return imageViews.size() * MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }

    public interface OnBannerViewClickListener {
        void OnItemClick(int position);
    }

}
