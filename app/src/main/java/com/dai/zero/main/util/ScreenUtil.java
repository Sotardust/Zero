package com.dai.zero.main.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Administrator on 2018/3/31 0031.
 */

public class ScreenUtil {

    private Point point;

    public ScreenUtil(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        point = new Point();
        display.getSize(point);
    }

    //获取屏幕宽度
    public int getWidth() {
        return point.x;
    }

    //获取屏幕高度
    public int getHeight() {
        return point.y;
    }

}
