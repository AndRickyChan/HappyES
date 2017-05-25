package com.ricky.happyes.ui.main.food;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.FoodTypeBean;
import com.ricky.happyes.bean.ShopListBean;

import java.util.List;

/**
 * 美食
 * Created by Ricky on 2017-5-25.
 */

interface FoodContract {

    interface View extends BaseView {
        void onLoadFoodTypeSuccess(List<FoodTypeBean> list);

        void onLoadFoodTypeError(int type);

        void onLoadShopRefresh(List<ShopListBean.ShopBean> list);

        void onLoadShopMore(List<ShopListBean.ShopBean> list);

        void onRefreshError(int type);

        void onLoadMoreError(int type);
    }

    interface Presenter extends BasePresenter {
        void getFoodTypeList(Context mContext);

        void getFoodContentList(Context mContext, int page, int count, String type);
    }
}
