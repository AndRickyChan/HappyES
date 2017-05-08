package com.ricky.happyes.util;

import android.util.Log;

import com.ricky.happyes.BuildConfig;

/**
 * 日志工具类
 * Created by Ricky on 2017-3-9.
 */

public class LogUtils {
    public static void i(String key, String value) {
        if (BuildConfig.IS_DEBUG) {
            Log.i(key, value);
        }
    }

    public static void d(String key, String value) {
        if (BuildConfig.IS_DEBUG) {
            Log.d(key, value);
        }
    }

    public static void e(String key, String value) {
        if (BuildConfig.IS_DEBUG) {
            Log.e(key, value);
        }
    }
}
