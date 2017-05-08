package com.ricky.happyes.ui.register;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;

/**
 * 注册
 * Created by Ricky on 2017-4-11.
 */

public interface RegisterContract {

    interface View extends BaseView {
        void onRegisterSuccess();
    }

    interface Presenter extends BasePresenter {
        boolean isNicknameValid(String nickname);

        boolean isPassValid(String password);

        void register(Context mContext, String phone, String nickname, String password);
    }
}
