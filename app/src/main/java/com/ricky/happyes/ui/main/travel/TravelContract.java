package com.ricky.happyes.ui.main.travel;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.TravelBean;

import java.util.List;

/**
 * 旅行
 * Created by Ricky on 2017-3-9.
 */

public interface TravelContract {
    interface View extends BaseView{
        void onLoadRefresh(List<TravelBean> list);

        void onLoadMore(List<TravelBean> list);

        void onLoadError(int type);

        void onNoMore();
    }

    interface Presenter extends BasePresenter{
        void getTravelList(Context mContext, int page, int count);
    }
}
