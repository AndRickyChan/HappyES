package com.ricky.happyes.util;

import android.content.Context;
import android.widget.Toast;

import com.ricky.happyes.app.HappyESApplication;

/**
 * 提示工具类
 * Created by Ricky on 2017-3-9.
 */

public class ToastUtils {

    public static void toastShort(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastShort(String msg) {
        Toast.makeText(HappyESApplication.getAppContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(Context mContext, String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    public static void toastLong(String msg) {
        Toast.makeText(HappyESApplication.getAppContext(), msg, Toast.LENGTH_LONG).show();
    }
}
