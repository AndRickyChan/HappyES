package com.ricky.happyes.ui.main.home;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.MyMessageListBean;
import com.ricky.happyes.bean.home.BannerBean;
import com.ricky.happyes.bean.home.HomeBean;

import java.util.List;

/**
 * 主页
 * Created by Ricky on 2017-3-9.
 */

public interface HomeContract {
    interface View extends BaseView {
        void onLoadBannerSuccess(List<BannerBean> list);

        void hideBanner();

       void showHomeData(HomeBean bean);
    }

    interface Presenter extends BasePresenter {
        void getHomeBanner(Context mContext);

        void getHomeData(Context mContext);
    }
}
