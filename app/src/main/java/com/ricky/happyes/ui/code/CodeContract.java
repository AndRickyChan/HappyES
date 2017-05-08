package com.ricky.happyes.ui.code;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;

/**
 * 获取验证码
 * Created by Ricky on 2017-3-18.
 */

public interface CodeContract {
    interface View extends BaseView {
        void onVerifySuccess();

        void onGetCodeSuccess();

    }

    interface Presenter extends BasePresenter {
        void getCode(Context mContext, String phone, int type);

        void verifyCode(Context mContext, String phone, int type, String code);

        boolean isPhoneValid(String phone);

        boolean isCodeValid(String code);
    }
}
