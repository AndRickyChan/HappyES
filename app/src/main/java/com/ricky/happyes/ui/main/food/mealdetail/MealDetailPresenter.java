package com.ricky.happyes.ui.main.food.mealdetail;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.mealdetail.MealDetailBean;
import com.ricky.happyes.bean.mealdetail.MealMenuBean;
import com.ricky.happyes.bean.mealdetail.MealMenuContentBean;
import com.ricky.happyes.bean.mealdetail.MealRuleBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 套餐详情
 * Created by Ricky on 2017-6-1.
 */

public class MealDetailPresenter extends RxPresenter<MealDetailContract.View> implements MealDetailContract.Presenter {
    public MealDetailPresenter(MealDetailContract.View mView) {
        super(mView);
    }

    @Override
    public void getCommonMealData(Context mContext, String mealId) {
        MealDetailBean commentBean = new MealDetailBean();
        commentBean.setMeal_id("13345");
        commentBean.setMeal_name("超值豪华鸡腿堡");
        commentBean.setMeal_bg("354");
        commentBean.setShop_phone("13477242213");
        commentBean.setMeal_price(15.2f);
        commentBean.setMeal_work_date("周一到周日，随时预定");
        commentBean.setMeal_use_day("09:30 - 17:30");
        List<MealRuleBean> ruleList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MealRuleBean bean = new MealRuleBean(String.valueOf(i), "套餐规则" + i + "号");
            ruleList.add(bean);
        }
        commentBean.setRuleList(ruleList);

        mView.onLoadCommonDataSuccess(commentBean);
    }

    @Override
    public void getMealMenuData(Context mContext, String mealId) {
        List<MealMenuBean> mAllData = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<MealMenuContentBean> tempList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                MealMenuContentBean content = new MealMenuContentBean("葫芦娃" + j + "号", j + "份", j + 2f, false);
                tempList.add(content);
            }
            MealMenuBean bean = new MealMenuBean("菜品" + i + "号", tempList);
            mAllData.add(bean);
        }
        mView.onLoadMealMenuSuccess(mAllData);
    }
}
