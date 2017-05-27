package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.MealBean;
import com.ricky.happyes.bean.ShopCommentBean;

import java.util.List;

/**
 * 店铺详情
 * Created by Ricky on 2017-5-27.
 */

public interface ShopContract {

    interface View extends BaseView{


        void onMealListSuccess(List<MealBean> list);

        void onCommentListSuccess(List<ShopCommentBean> list);

    }

    interface Presenter extends BasePresenter{

        void getMealList(Context mContext,String shopId);

        void getCommentList(Context mContext,String shopId);

        void getCommonData(Context mContext,String shopId);

    }
}
