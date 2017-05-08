package com.ricky.happyes.ui.setting;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;

/**
 * 设置
 * Created by Ricky on 2017-3-13.
 */

public interface SettingContract {
    interface View extends BaseView {
        void setCacheSize(String cache);

        void logoutSuccess();

        void updatePushStatusUI(boolean isPush);

    }

    interface Presenter extends BasePresenter {
        void clearCache(Context mContext);

        void logout(Context mContext);

        void changePushStatus(Context mContext,boolean isPush);
    }
}
