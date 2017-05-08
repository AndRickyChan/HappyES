package com.ricky.happyes.util;

import android.content.Context;
import android.view.WindowManager;

/**
 * 获取屏幕相关信息的工具类
 * Created by Ricky on 2017-4-11.
 */

public class DensityUtils {

    private DensityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int dp2px(Context mContext, float dpValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(Context mContext, float pxValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(Context mContext, float spValue) {
        float scale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }

    public static int px2sp(Context mContext, float pxValue) {
        float scale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取手机屏幕宽度
     *
     * @param mContext 上下文
     * @return int
     */
    public static int getScreenWidth(Context mContext) {
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕
     *
     * @param mContext 上下文
     * @return int
     */
    public static int getScreenHeight(Context mContext) {
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        return manager.getDefaultDisplay().getHeight();
    }
}
