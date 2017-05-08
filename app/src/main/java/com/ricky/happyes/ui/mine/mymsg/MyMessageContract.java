package com.ricky.happyes.ui.mine.mymsg;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.MyMessageListBean;
import com.ricky.happyes.widgets.CustomErrorView;

import java.util.List;

/**
 * 我的消息
 * Created by Ricky on 2017-3-14.
 */

public interface MyMessageContract {
    interface View extends BaseView {
        void onRefreshData(List<MyMessageListBean.MyMessage> list);

        void onLoadMoreData(List<MyMessageListBean.MyMessage> list);

        void onRefreshError(int type);

        void onLoadMoreError(int type);
    }

    interface Presenter extends BasePresenter {
        void getMyMessage(Context mContext, int page, int count);
    }
}
