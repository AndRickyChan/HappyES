package com.ricky.happyes.ui.mine.collection.shop;

import com.ricky.happyes.base.RxPresenter;

/**
 * 店铺收藏
 * Created by Ricky on 2017-5-26.
 */

public class ShopCollectionPresenter extends RxPresenter<ShopCollectionContract.View> implements ShopCollectionContract.Presenter {

    public ShopCollectionPresenter(ShopCollectionContract.View mView) {
        super(mView);
    }
}
