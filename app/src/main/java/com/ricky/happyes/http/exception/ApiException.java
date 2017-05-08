package com.ricky.happyes.http.exception;

/**
 * 自定义错误处理
 * Created by Ricky on 2017-4-10.
 */

public class ApiException extends Exception {
    public ApiException(String msg) {
        super(msg);
    }
}
