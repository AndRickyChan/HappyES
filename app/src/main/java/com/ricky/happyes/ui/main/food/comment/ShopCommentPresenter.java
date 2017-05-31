package com.ricky.happyes.ui.main.food.comment;

import com.ricky.happyes.base.RxPresenter;

/**
 * 评论列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopCommentPresenter extends RxPresenter<ShopCommentContract.View> implements ShopCommentContract.Presenter{

    public ShopCommentPresenter(ShopCommentContract.View mView) {
        super(mView);
    }
}
