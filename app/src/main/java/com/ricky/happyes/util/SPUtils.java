package com.ricky.happyes.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import com.ricky.happyes.app.Constants;

/**
 * SharedPreferences工具类
 * Created by Ricky on 2017-3-7.
 */

public class SPUtils {

    private static final String FILE_NAME = "happy_es_file";

    private SPUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void put(Context mContext, String key, Object value) {
        SharedPreferences sp = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        }

        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    public static Object get(Context mContext, String key, Object defValue) {
        SharedPreferences sp = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);

        if (defValue instanceof String) {
            return sp.getString(key, (String) defValue);
        } else if (defValue instanceof Integer) {
            return sp.getInt(key, (Integer) defValue);
        } else if (defValue instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defValue);
        } else if (defValue instanceof Long) {
            return sp.getLong(key, (Long) defValue);
        } else if (defValue instanceof Float) {
            return sp.getFloat(key, (Float) defValue);
        } else {
            return null;
        }
    }

    public static void remove(Context mContext, String key) {
        SharedPreferences sp = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    public static void clear(Context mContext) {
        SharedPreferences sp = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }

    /**
     * 清除本地保存的用户数据
     *
     * @param mContext 上下文
     */
    public static void clearUserData(Context mContext) {
        SharedPreferences sp = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(Constants.IS_LOGIN);
        editor.remove(Constants.HAPPY_ES_TOKEN);
        editor.remove(Constants.ACCEPT_PUSH_MESSAGE);
        SharedPreferencesCompat.EditorCompat.getInstance().apply(editor);
    }
}
