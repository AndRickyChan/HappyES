package com.ricky.happyes.http.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ricky.happyes.app.Constants;
import com.ricky.happyes.http.exception.ApiException;

import rx.Subscriber;

/**
 * 数据结果处理基类
 * Created by Ricky on 2017-4-10.
 */

public abstract class RxSubscribe<T> extends Subscriber<T> {

    private Context mContext;
    private String progressContent = "";
    private MaterialDialog progressDialog;//网络请求进度条

    public RxSubscribe(Context mContext) {
        this.mContext = mContext;
        progressContent = "请稍等...";
    }

    public RxSubscribe(Context mContext, String progressContent) {
        this.mContext = mContext;
        this.progressContent = progressContent;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (showProgress()) {
            progressDialog = new MaterialDialog.Builder(mContext)
                    .content(progressContent)
                    .progress(true, 0)
                    .dismissListener(dialog -> {
                        if (isUnsubscribed())
                            unsubscribe();
                    })
                    .build();
            progressDialog.show();
        }
    }

    @Override
    public void onCompleted() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onError(Throwable e) {
        if (!NetworkUtils.isConnected(mContext))
            _onError(Constants.COMMON_NET_ERROR, "网络状态不可用");
        else if (e instanceof ApiException)
            _onError(Constants.COMMON_SERVICE_ERROR, e.getMessage());
        else
            _onError(Constants.COMMON_OTHER_ERROR, "其他未知错误");
        //隐藏进度条
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    /**
     * 是否显示进度条
     */
    public boolean showProgress() {
        return true;
    }

    public abstract void _onNext(T t);

    public abstract void _onError(int errorCode, String message);

}
