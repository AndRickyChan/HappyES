package com.ricky.happyes.ui.main;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.UserBean;

/**
 * 主界面
 * Created by Ricky on 2017-3-18.
 */

public interface MainContract {
    interface View extends BaseView {
        void onLoadUserInfoSuccess(UserBean bean);

        void onLoadUserInfoError();
    }

    interface Presenter extends BasePresenter {
        void getUserInfo(Context mContext);
    }
}
