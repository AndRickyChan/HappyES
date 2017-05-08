package com.ricky.happyes.http.api;


import com.ricky.happyes.bean.BaseBean;
import com.ricky.happyes.bean.LoginBean;
import com.ricky.happyes.bean.NullBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 接口地址
 * Created by Ricky on 2017-4-12.
 */

public interface HappyESApis {
    /**
     * 获取验证码
     */
    @FormUrlEncoded
    @POST("account/get_verification_code")
    Observable<BaseBean<NullBean>> getCode(@FieldMap Map<String, String> params);

    /**
     * 校验验证码
     */
    @FormUrlEncoded
    @POST("account/verify_code")
    Observable<BaseBean<NullBean>> verifiCode(@FieldMap Map<String, String> params);


    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("account/register")
    Observable<BaseBean<NullBean>> register(@FieldMap Map<String, String> params);

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("account/login")
    Observable<BaseBean<LoginBean>> login(@FieldMap Map<String, String> params);
}
