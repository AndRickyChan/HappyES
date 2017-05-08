package com.ricky.happyes.ui.mine.mymsg;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.bean.MyMessageListBean;
import com.ricky.happyes.widgets.CustomErrorView;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的消息
 * Created by Ricky on 2017-3-14.
 */

public class MyMessagePresenter extends RxPresenter<MyMessageContract.View> implements MyMessageContract.Presenter {

    public MyMessagePresenter(MyMessageContract.View mView) {
        super(mView);
    }

    @Override
    public void getMyMessage(Context mContext, final int page, int count) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                List<MyMessageListBean.MyMessage> list = new ArrayList<MyMessageListBean.MyMessage>();
                for (int i = 0; i < 5; i++) {
                    MyMessageListBean.MyMessage message = new MyMessageListBean().new MyMessage();
                    message.setId(i);
                    message.setTitle("葫芦娃" + (i + 1) + "号");
                    message.setContent("一人 我饮酒醉两眼 是独相随只求他日能双归娇女 我轻扶琴燕嬉 我紫竹林我痴情红颜心甘情愿千里把君寻说红颜 我痴情笑曲动 我琴声妙我轻狂高傲懵懂无");
                    message.setCreateTime("2017-03-14 16:08");
                    list.add(message);
                }
                if (page == 1) {
                    mView.onRefreshData(list);
                } else if (page == 3) {
                    mView.onLoadMoreError(CustomErrorView.ERROR_TYPE_EMPTY);
                } else {
                    mView.onLoadMoreData(list);
                }
            }
        }, 1000);
    }
}
