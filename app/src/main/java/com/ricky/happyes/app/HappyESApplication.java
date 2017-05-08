package com.ricky.happyes.app;

import android.app.Application;
import android.content.Context;

import com.ricky.happyes.util.SPUtils;

/**
 * application
 * Created by Ricky on 2017-3-9.
 */

public class HappyESApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        initCommon();
    }

    public void initCommon() {
        boolean isFirst = (boolean) SPUtils.get(this, Constants.APP_FIRST_LOADING, true);
        if (isFirst) {
            SPUtils.put(this, Constants.ACCEPT_PUSH_MESSAGE, true);
        }
    }

    public static Context getAppContext() {
        return mContext;
    }

}
