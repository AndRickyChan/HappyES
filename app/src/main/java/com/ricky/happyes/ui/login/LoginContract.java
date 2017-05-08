package com.ricky.happyes.ui.login;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;

/**
 * 登錄
 * Created by Ricky on 2017-3-18.
 */

public interface LoginContract {
    interface View extends BaseView {
        void onLoginSuccess();
    }

    interface Presenter extends BasePresenter {

        boolean isPhoneValid(String phone);

        boolean isPassValid(String password);

        void login(Context mContext, String phone, String password);
    }
}
