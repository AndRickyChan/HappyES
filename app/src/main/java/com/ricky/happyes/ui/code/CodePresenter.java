package com.ricky.happyes.ui.code;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.NullBean;
import com.ricky.happyes.http.RetrofitHelper;
import com.ricky.happyes.http.util.RxSubscribe;
import com.ricky.happyes.http.util.RxUtils;
import com.ricky.happyes.util.CommonUtils;

import rx.Subscription;

/**
 * 获取验证码
 * Created by Ricky on 2017-3-18.
 */

public class CodePresenter extends RxPresenter<CodeContract.View> implements CodeContract.Presenter {

    public CodePresenter(CodeContract.View mView) {
        super(mView);
    }

    @Override
    public void getCode(Context mContext, String phone, int type) {
        if (!CommonUtils.isPhone(phone)) {
            mView.showError("请填写正确的手机号码");
            return;
        }
        Subscription subscription = RetrofitHelper.getInstance(mContext).getVerificationCode(phone, String.valueOf(type))
                .compose(RxUtils.handleResult())
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new RxSubscribe<NullBean>(mContext) {
                    @Override
                    public void _onNext(NullBean nullBean) {
                        mView.onGetCodeSuccess();
                    }

                    @Override
                    public void _onError(int errorCode, String message) {
                        mView.showError(message);
                    }
                });
        addSubscription(subscription);
    }

    @Override
    public void verifyCode(Context mContext, String phone, int type, String code) {
        Subscription subscription = RetrofitHelper.getInstance(mContext)
                .verifiCode(phone, String.valueOf(type), code)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribe(new RxSubscribe<NullBean>(mContext) {
                    @Override
                    public void _onNext(NullBean nullBean) {
                        mView.onVerifySuccess();
                    }

                    @Override
                    public void _onError(int errorCode, String message) {
                        mView.showError(message);
                    }
                });
        addSubscription(subscription);
    }

    @Override
    public boolean isPhoneValid(String phone) {
        return phone.length() == 11;
    }

    @Override
    public boolean isCodeValid(String code) {
        return code.length() >= 4;
    }
}
