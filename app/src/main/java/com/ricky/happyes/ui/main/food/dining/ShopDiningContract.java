package com.ricky.happyes.ui.main.food.dining;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.shopdetail.MealBean;

import java.util.List;

/**
 * 套餐列表
 * Created by Ricky on 2017-5-31.
 */

public interface ShopDiningContract {

    interface View extends BaseView {

        void onLoadRefreshSuccess(List<MealBean> list);

        void onLoadMoreSuccess(List<MealBean> list);

        void onRefreshError(int type);

        void onLoadMoreError(int type);
    }

    interface Presenter extends BasePresenter{
        void getDiningData(Context mContext,int page,int count,String shopId);
    }
}
