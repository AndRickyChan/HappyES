package com.ricky.happyes.ui.main.food.dining;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.shopdetail.MealBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 套餐列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopDiningPresenter extends RxPresenter<ShopDiningContract.View> implements ShopDiningContract.Presenter {

    public ShopDiningPresenter(ShopDiningContract.View mView) {
        super(mView);
    }

    @Override
    public void getDiningData(Context mContext, int page, int count, String shopId) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                List<MealBean> mealList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    MealBean bean = new MealBean();
                    bean.setMeal_logo("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3025700168,578577511&fm=23&gp=0.jpg");
                    bean.setMeal_name("单人超值汉堡套餐");
                    bean.setMeal_day("周一到周六");
                    bean.setNeed_predate(false);
                    bean.setMeal_price(16.5f);
                    mealList.add(bean);
                }
                mView.onLoadRefreshSuccess(mealList);
            }
        }, 1000);
    }
}
