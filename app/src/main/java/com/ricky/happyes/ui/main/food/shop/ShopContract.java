package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.shopdetail.MealBean;
import com.ricky.happyes.bean.shopdetail.ShopCommentBean;
import com.ricky.happyes.bean.shopdetail.ShopDetailBean;

import java.util.List;

/**
 * 店铺详情
 * Created by Ricky on 2017-5-27.
 */

public interface ShopContract {

    interface View extends BaseView{

        void onLoadDataSuccess(ShopDetailBean bean);
    }

    interface Presenter extends BasePresenter{

        void getShopDetailData(Context mContext,String shopId);

    }
}
