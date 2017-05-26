package com.ricky.happyes.ui.register;

import android.content.Context;

import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.BaseBean;
import com.ricky.happyes.bean.NullBean;
import com.ricky.happyes.http.RetrofitHelper;
import com.ricky.happyes.http.util.RxSubscribe;
import com.ricky.happyes.http.util.RxUtils;

import rx.Subscription;

/**
 * 注册
 * Created by Ricky on 2017-4-11.
 */

public class RegisterPresenter extends RxPresenter<RegisterContract.View> implements RegisterContract.Presenter {

    public RegisterPresenter(RegisterContract.View mView) {
        super(mView);
    }

    @Override
    public boolean isNicknameValid(String nickname) {
        return nickname.length() >= Constants.NICKNAME_MIN_LENGTH && nickname.length() <= Constants.NICKNAME_MAX_LENGTH;
    }

    @Override
    public boolean isPassValid(String password) {
        return password.length() >= Constants.PASSWORD_MIN_LENGTH && password.length() <= Constants.PASSWORD_MAX_LENGTH;
    }

    @Override
    public void register(Context mContext, String phone, String nickname, String password) {
        /*Subscription subscription = RetrofitHelper.getInstance(mContext)
                .register(phone, nickname, password)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribe(new RxSubscribe<NullBean>(mContext) {
                    @Override
                    public void _onNext(NullBean nullBean) {
                        mView.onRegisterSuccess();
                    }

                    @Override
                    public void _onError(int errorCode, String message) {
                        mView.onRegisterSuccess();
                    }
                });
        addSubscription(subscription);*/
        mView.onRegisterSuccess();
    }
}
