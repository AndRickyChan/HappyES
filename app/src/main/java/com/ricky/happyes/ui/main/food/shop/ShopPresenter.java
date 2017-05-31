package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.shopdetail.AdviceMealBean;
import com.ricky.happyes.bean.shopdetail.MealBean;
import com.ricky.happyes.bean.shopdetail.ShopCommentBean;
import com.ricky.happyes.bean.shopdetail.ShopDetailBean;

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
    public void getShopDetailData(Context mContext, String shopId) {

        ShopDetailBean detailBean = new ShopDetailBean();
        detailBean.setShop_id("12345678");
        detailBean.setShop_name("家家腊鱼馆");
        detailBean.setShop_bg_logo("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3025700168,578577511&fm=23&gp=0.jpg");
        detailBean.setShop_star(4);
        detailBean.setShop_average_price(25);
        detailBean.setCollection(true);
        detailBean.setShop_address("湖北省恩施市沿江路凤凰山隧道旁移动摊位3号");
        detailBean.setShop_phone("13477242213");

        List<MealBean> mealList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            MealBean bean = new MealBean();
            bean.setMeal_logo("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3025700168,578577511&fm=23&gp=0.jpg");
            bean.setMeal_name("单人超值汉堡套餐");
            bean.setMeal_day("周一到周六");
            bean.setNeed_predate(false);
            bean.setMeal_price(16.5f);
            mealList.add(bean);
        }
        detailBean.setMealList(mealList);

        List<ShopCommentBean> commentList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ShopCommentBean bean = new ShopCommentBean();
            bean.setComment_id("" + i);
            bean.setUser_header("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3025700168,578577511&fm=23&gp=0.jpg");
            bean.setUser_name("小痴");
            bean.setStar_count(5);
            bean.setComment_time("2017-05-27");
            bean.setComment("这家店还是有很多好吃的，但是还是要具有一双发现美的眼睛才能让自己得到幸福...哈哈哈哈.....");
            commentList.add(bean);
        }
        detailBean.setCommentBeanList(commentList);

        List<AdviceMealBean> adviceMealBeanList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AdviceMealBean adviceMealBean = new AdviceMealBean();
            adviceMealBean.setName("汉堡" + i + "号");
            adviceMealBeanList.add(adviceMealBean);
        }
        detailBean.setAdviceMealList(adviceMealBeanList);

        mView.onLoadDataSuccess(detailBean);
    }
}
