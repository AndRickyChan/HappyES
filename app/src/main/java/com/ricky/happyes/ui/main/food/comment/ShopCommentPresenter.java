package com.ricky.happyes.ui.main.food.comment;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.shopdetail.ShopCommentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 评论列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopCommentPresenter extends RxPresenter<ShopCommentContract.View> implements ShopCommentContract.Presenter {

    public ShopCommentPresenter(ShopCommentContract.View mView) {
        super(mView);
    }

    @Override
    public void getCommentList(Context mContext, int page, int count, String shopId) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                List<ShopCommentBean> commentList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    ShopCommentBean bean = new ShopCommentBean();
                    bean.setComment_id("" + i);
                    bean.setUser_header("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3025700168,578577511&fm=23&gp=0.jpg");
                    bean.setUser_name("小痴");
                    bean.setStar_count(5);
                    bean.setComment_time("2017-05-27");
                    bean.setComment("这家店还是有很多好吃的，但是还是要具有一双发现美的眼睛才能让自己得到幸福...哈哈哈哈.....");
                    commentList.add(bean);
                }
                mView.onRefreshSuccess(commentList);
            }
        }, 1000);
    }
}
