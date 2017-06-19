package com.ricky.happyes.ui.main.travel.detail;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.traveldetail.TravelDetailBean;

/**
 * 景点详情
 * Created by Ricky on 2017-6-19.
 */

public interface TravelDetailContract {
    interface View extends BaseView {
        void onLoadTravelDetailSuccess(TravelDetailBean bean);

        void onLoadTravelDetailError(int type);
    }

    interface Presenter extends BasePresenter {
        void getTravelDetail(Context mContext, String travelId);
    }
}
