package com.ricky.happyes.ui.main.food.comment;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;
import com.ricky.happyes.bean.shopdetail.ShopCommentBean;

import java.util.List;

/**
 * 评论列表
 * Created by Ricky on 2017-5-31.
 */

public interface ShopCommentContract {
    interface View extends BaseView {
        void onRefreshSuccess(List<ShopCommentBean> list);

        void onLoadMoreSuccess(List<ShopCommentBean> list);

        void onRefreshError(int type);

        void onLoadMoreError(int type);
    }

    interface Presenter extends BasePresenter {
        void getCommentList(Context mContext, int page, int count, String shopId);
    }
}
