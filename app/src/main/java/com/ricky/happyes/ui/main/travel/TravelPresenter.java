package com.ricky.happyes.ui.main.travel;

import com.ricky.happyes.base.RxPresenter;

/**
 * 旅行
 * Created by Ricky on 2017-3-9.
 */

public class TravelPresenter extends RxPresenter<TravelContract.View> implements TravelContract.Presenter {

    public TravelPresenter(TravelContract.View mView) {
        super(mView);
    }
}
