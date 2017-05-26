package com.ricky.happyes.ui.resetpass;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;

/**
 * 重置密码
 * Created by Ricky on 2017-4-11.
 */
interface ResetPassContract {

    interface View extends BaseView {
        void onResetSuccess();
    }

    interface Presenter extends BasePresenter {
        void resetPassword(Context mContext,String newPass,String confirmPass);
    }
}
