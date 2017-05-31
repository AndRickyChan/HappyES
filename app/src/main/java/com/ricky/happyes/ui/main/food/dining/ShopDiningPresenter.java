package com.ricky.happyes.ui.main.food.dining;

import com.ricky.happyes.base.RxPresenter;

/**
 * 套餐列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopDiningPresenter extends RxPresenter<ShopDiningContract.View> implements ShopDiningContract.Presenter{

    public ShopDiningPresenter(ShopDiningContract.View mView) {
        super(mView);
    }
}
