package com.ricky.happyes.ui.login;

import android.content.Context;

import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.LoginBean;
import com.ricky.happyes.http.RetrofitHelper;
import com.ricky.happyes.http.util.RxSubscribe;
import com.ricky.happyes.http.util.RxUtils;

import rx.Subscription;

/**
 * 登录
 * Created by Ricky on 2017-3-18.
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {

    public LoginPresenter(LoginContract.View mView) {
        super(mView);
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return phone.length() == 11;
    }

    @Override
    public boolean isPassValid(String password) {
        return password.length() >= Constants.PASSWORD_MIN_LENGTH && password.length() <= Constants.PASSWORD_MAX_LENGTH;
    }

    @Override
    public void login(Context mContext, String phone, String password) {
        /*Subscription subscription = RetrofitHelper.getInstance(mContext).login(phone, password)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribe(new RxSubscribe<LoginBean>(mContext) {
                    @Override
                    public void _onNext(LoginBean loginBean) {
                        mView.onLoginSuccess();
                    }

                    @Override
                    public void _onError(int errorCode, String message) {
                        mView.showError(message);
                    }
                });
        addSubscription(subscription);*/

        mView.onLoginSuccess();
    }
}
