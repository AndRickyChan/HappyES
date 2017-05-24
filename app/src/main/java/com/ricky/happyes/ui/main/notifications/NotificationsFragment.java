package com.ricky.happyes.ui.main.notifications;

import android.content.Context;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseFragment;
import com.ricky.happyes.util.ToastUtils;

/**
 * 公告
 * Created by Ricky on 2017-3-9.
 */

public class NotificationsFragment extends BaseFragment<NotificationsPresenter> implements NotificationsContract.View {

    private Context mContext;


    @Override
    public NotificationsPresenter getPresenter() {
        return new NotificationsPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_notifications;
    }

    @Override
    public void initEventAndData() {
        mContext = getContext();
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(mContext, msg);
    }
}
