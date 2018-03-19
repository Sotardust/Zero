package com.dai.zero.main.main.find.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.dai.zero.R;

/**
 * Created by dai on 2018/3/19.
 */

public class Banner extends RelativeLayout {
    public Banner(Context context) {
        super(context);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.module_view_banner, this, false);


    }


    public static class Builder {

        private Context context;

        //自动轮播的时间间隔(s)
        private int intervalTime = 5;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setIntervalTime(int intervalTime) {
            this.intervalTime = intervalTime;
            return this;
        }

        public Banner build() {

            return new Banner(context);
        }
    }
}
