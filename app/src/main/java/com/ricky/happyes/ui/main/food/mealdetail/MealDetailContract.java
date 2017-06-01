package com.ricky.happyes.ui.main.food.mealdetail;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.mealdetail.MealDetailBean;
import com.ricky.happyes.bean.mealdetail.MealMenuBean;

import java.util.List;

/**
 * 套餐详情
 * Created by Ricky on 2017-6-1.
 */

public interface MealDetailContract {

    interface View extends BaseView {
        void onLoadCommonDataSuccess(MealDetailBean bean);

        void onLoadMealMenuSuccess(List<MealMenuBean> list);
    }

    interface Presenter extends BasePresenter {
        void getCommonMealData(Context mContext, String mealId);

        void getMealMenuData(Context mContext, String mealId);
    }
}
