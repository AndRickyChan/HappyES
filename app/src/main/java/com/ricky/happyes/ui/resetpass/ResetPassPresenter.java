package com.ricky.happyes.ui.resetpass;

import android.content.Context;

import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.RxPresenter;

/**
 * 重置密码
 * Created by Ricky on 2017-4-11.
 */

public class ResetPassPresenter extends RxPresenter<ResetPassContract.View> implements ResetPassContract.Presenter {

    public ResetPassPresenter(ResetPassContract.View mView) {
        super(mView);
    }


    @Override
    public void resetPassword(Context mContext, String newPass, String confirmPass) {
        mView.onResetSuccess();
    }

    public boolean isNewPassValidate(String newPass) {
        return newPass.length() >= Constants.PASSWORD_MIN_LENGTH && newPass.length() <= Constants.PASSWORD_MAX_LENGTH;
    }

    public boolean isConfirmPassValidate(String confirmPass) {
        return confirmPass.length() >= Constants.PASSWORD_MIN_LENGTH && confirmPass.length() <= Constants.PASSWORD_MAX_LENGTH;
    }
}
