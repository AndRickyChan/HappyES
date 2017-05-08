package com.ricky.happyes.ui.setting.feedback;

import android.content.Context;

import com.ricky.happyes.base.BasePresenter;
import com.ricky.happyes.base.BaseView;

/**
 * 意见反馈
 * Created by Ricky on 2017-3-13.
 */

public interface FeedBackContract {
    interface View extends BaseView{

    }

    interface Presenter extends BasePresenter{
        void submitFeedBack(Context mContext, String content);
    }
}
