package com.ricky.happyes.http.interceptor;

import android.content.Context;

import com.ricky.happyes.app.Constants;
import com.ricky.happyes.util.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求添加头部拦截器
 * Created by Ricky on 2017-4-10.
 */

public class HeaderInteceptor implements Interceptor {

    private Context mContext;

    public HeaderInteceptor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("Authorization", "Bearer " + SPUtils.get(mContext, Constants.HAPPY_ES_TOKEN, ""))
                .addHeader("app_version", "1")
                .build();
        return chain.proceed(request);
    }
}
