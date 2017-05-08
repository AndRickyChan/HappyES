package com.ricky.happyes.http.okhttp;

import android.content.Context;

import com.ricky.happyes.BuildConfig;
import com.ricky.happyes.http.cookie.CookieManger;
import com.ricky.happyes.http.interceptor.CacheInterceptor;
import com.ricky.happyes.http.interceptor.HeaderInteceptor;
import com.ricky.happyes.util.DataCleanUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * OkHttp管理类
 * Created by Ricky on 2017-4-12.
 */

public class OkHttpManager {

    private static OkHttpClient mOkHttpClient;
    private static OkHttpManager manager;

    private OkHttpManager(Context mContext) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.IS_DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        File cacheFile = new File(DataCleanUtils.getCachePath(mContext) + "/HappyESCache");
        int cacheSize = 1024 * 1024 * 100;//100MB
        Cache cache = new Cache(cacheFile, cacheSize);

        builder.addInterceptor(loggingInterceptor);//设置log拦截器
        builder.addInterceptor(new HeaderInteceptor(mContext));//设置添加header拦截器
        builder.addNetworkInterceptor(new CacheInterceptor());//设置缓存拦截器
        builder.cache(cache);//设置缓存目录和缓存大小
        builder.cookieJar(new CookieManger(mContext));//设置cookie本地化
        builder.connectTimeout(15, TimeUnit.SECONDS);//设置连接超时时间
        builder.readTimeout(15, TimeUnit.SECONDS);//设置读取超时时间
        builder.writeTimeout(15, TimeUnit.SECONDS);//设置写入超时时间
        builder.retryOnConnectionFailure(true);//设置错误后重连

        mOkHttpClient = builder.build();
    }

    public static OkHttpManager getInstance(Context mContext) {
        if (manager == null) {
            synchronized (OkHttpManager.class) {
                if (manager == null) {
                    manager = new OkHttpManager(mContext);
                }
            }
        }
        return manager;
    }

    public OkHttpClient getClient() {
        return mOkHttpClient;
    }
}
