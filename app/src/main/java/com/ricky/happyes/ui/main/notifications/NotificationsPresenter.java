package com.ricky.happyes.ui.main.notifications;

import com.ricky.happyes.base.RxPresenter;

/**
 * 公告
 * Created by Ricky on 2017-3-9.
 */

public class NotificationsPresenter extends RxPresenter<NotificationsContract.View> implements NotificationsContract.Presenter {

    public NotificationsPresenter(NotificationsContract.View mView) {
        super(mView);
    }
}
