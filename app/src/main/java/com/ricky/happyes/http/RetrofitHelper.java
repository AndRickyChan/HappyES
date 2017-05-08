package com.ricky.happyes.http;

import android.content.Context;

import com.ricky.happyes.bean.BaseBean;
import com.ricky.happyes.bean.LoginBean;
import com.ricky.happyes.bean.NullBean;
import com.ricky.happyes.http.api.HappyESApis;
import com.ricky.happyes.http.okhttp.OkHttpManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * 接口管理类
 * Created by Ricky on 2017-4-12.
 */

public class RetrofitHelper {

    private static RetrofitHelper mRetrofitHelper;
    private HappyESApis happyESApis;

    private RetrofitHelper(Context mContext) {
        happyESApis = getApiService(mContext, "baseUrl", HappyESApis.class);
    }

    public static RetrofitHelper getInstance(Context mContext) {
        if (mRetrofitHelper == null) {
            synchronized (RetrofitHelper.class) {
                if (mRetrofitHelper == null) {
                    mRetrofitHelper = new RetrofitHelper(mContext);
                }
            }
        }
        return mRetrofitHelper;
    }

    private <T> T getApiService(Context mContext, String baseUrl, Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpManager.getInstance(mContext).getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(clazz);
    }

    //定义接口处理

    /**
     * 获取验证码
     */
    public Observable<BaseBean<NullBean>> getVerificationCode(String phone, String type) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("type", type);
        return happyESApis.getCode(params);
    }

    /**
     * 校验验证码
     */
    public Observable<BaseBean<NullBean>> verifiCode(String phone, String type, String code) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("type", type);
        params.put("code", code);
        return happyESApis.verifiCode(params);
    }

    /**
     * 注册
     */
    public Observable<BaseBean<NullBean>> register(String phone, String nickname, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("nickname", nickname);
        params.put("password", password);
        return happyESApis.register(params);
    }

    /**
     * 登录
     */
    public Observable<BaseBean<LoginBean>> login(String phone, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("password", password);
        params.put("client_id", password);
        params.put("client_secret", password);
        params.put("scope", "read");
        params.put("grant_type", "password");
        return happyESApis.login(params);
    }
}
