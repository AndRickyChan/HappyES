package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.MealBean;
import com.ricky.happyes.bean.ShopCommentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 店铺详情
 * Created by Ricky on 2017-5-27.
 */

public class ShopPresenter extends RxPresenter<ShopContract.View> implements ShopContract.Presenter {

    public ShopPresenter(ShopContract.View mView) {
        super(mView);
    }

    @Override
    public void getMealList(Context mContext, String shopId) {
        List<MealBean> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            MealBean bean = new MealBean();
            bean.setMeal_logo("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3025700168,578577511&fm=23&gp=0.jpg");
            bean.setMeal_name("单人超值汉堡套餐");
            bean.setMeal_day("周一到周六");
            bean.setNeed_predate(false);
            bean.setMeal_price(16.5f);
            list.add(bean);
        }
        mView.onMealListSuccess(list);
    }

    @Override
    public void getCommentList(Context mContext, String shopId) {
        List<ShopCommentBean> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ShopCommentBean bean = new ShopCommentBean();
            bean.setComment_id("" + i);
            bean.setUser_header("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3025700168,578577511&fm=23&gp=0.jpg");
            bean.setUser_name("小痴");
            bean.setStar_count(5);
            bean.setComment_time("2017-05-27");
            bean.setComment("这家店还是有很多好吃的，但是还是要具有一双发现美的眼睛才能让自己得到幸福...哈哈哈哈.....");
            list.add(bean);
        }
        mView.onCommentListSuccess(list);
    }

    @Override
    public void getCommonData(Context mContext, String shopId) {

    }
}
