package com.ricky.happyes.ui.main;

import android.content.Context;

import com.ricky.happyes.base.RxPresenter;

/**
 * 主界面
 * Created by Ricky on 2017-3-18.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    public MainPresenter(MainContract.View mView) {
        super(mView);
    }

    @Override
    public void getUserInfo(Context mContext) {

    }
}
