package com.ricky.happyes.app;

/**
 * 常量
 * Created by Ricky on 2017-3-9.
 */

public class Constants {

    public static final String APP_FIRST_LOADING = "app_first_loading";//是否是第一次启动APP
    public static final String ACCEPT_PUSH_MESSAGE = "accept_push_message";//是否接收推送消息的key

    public static final int PAGE_SIZE = 10;//页面大小

    //通用处理错误码
    public static final int COMMON_NET_ERROR = 2001;//没网
    public static final int COMMON_SERVICE_ERROR = 2002;//服务器错误
    public static final int COMMON_OTHER_ERROR = 2003;//其他错误
    public static final int COMMON_DATA_ERROR = 2004;//数据为空
    //用户相关存储信息
    public static final String IS_LOGIN = "is_login";//是否已经登录
    public static final String HAPPY_ES_TOKEN = "happy_es_token";//token


    //普通常量
    public static final int PASSWORD_MIN_LENGTH = 6;    //密码最短长度限制
    public static final int PASSWORD_MAX_LENGTH = 18;   //密码最长长度限制
    public static final int NICKNAME_MIN_LENGTH = 2;    //昵称最短长度限制
    public static final int NICKNAME_MAX_LENGTH = 10;   //昵称最长长度限制
}
