package com.ricky.happyes.ui.setting.feedback;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;

/**
 * 意见反馈
 * Created by Ricky on 2017-3-13.
 */

public class FeedBackPresenter extends RxPresenter<FeedBackContract.View> implements FeedBackContract.Presenter{

    public FeedBackPresenter(FeedBackContract.View mView) {
        super(mView);
    }

    @Override
    public void submitFeedBack(Context mContext, String content) {

    }
}
