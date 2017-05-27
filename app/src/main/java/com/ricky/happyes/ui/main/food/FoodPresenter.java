package com.ricky.happyes.ui.main.food;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.FoodTypeBean;
import com.ricky.happyes.bean.ShopListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 美食
 * Created by Ricky on 2017-5-25.
 */

public class FoodPresenter extends RxPresenter<FoodContract.View> implements FoodContract.Presenter {

    public FoodPresenter(FoodContract.View mView) {
        super(mView);
    }

    @Override
    public void getFoodTypeList(Context mContext) {
        List<FoodTypeBean> list = new ArrayList<FoodTypeBean>();
        list.add(new FoodTypeBean("1", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "全部", true));
        list.add(new FoodTypeBean("2", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "自助餐", false));
        list.add(new FoodTypeBean("3", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "火锅", false));
        list.add(new FoodTypeBean("4", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "外卖", false));
        list.add(new FoodTypeBean("5", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "云贵菜", false));
        list.add(new FoodTypeBean("6", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "川湘菜", false));
        list.add(new FoodTypeBean("7", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "生日蛋糕", false));
        list.add(new FoodTypeBean("8", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg", "海鲜", false));
        mView.onLoadFoodTypeSuccess(list);
    }

    @Override
    public void getFoodContentList(Context mContext, int page, int count, String type) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                List<ShopListBean.ShopBean> list = new ArrayList<ShopListBean.ShopBean>();
                for (int i = 0; i < 5; i++) {
                    ShopListBean.ShopBean bean = new ShopListBean().new ShopBean();
                    bean.setShop_id("" + i);
                    bean.setShop_logo("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3548260537,2899382870&fm=23&gp=0.jpg");
                    bean.setShop_title("家家腊鱼馆" + i + "号");
                    bean.setShop_price(16);
                    bean.setShop_star(5);
                    bean.setShop_address("恩施/新天地");
                    bean.setShop_type("土家特色菜");
                    list.add(bean);
                }
                mView.onLoadShopRefresh(list);
            }
        }, 1000);
    }
}
