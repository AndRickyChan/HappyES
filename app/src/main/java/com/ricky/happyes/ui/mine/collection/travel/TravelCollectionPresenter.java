package com.ricky.happyes.ui.mine.collection.travel;

import com.ricky.happyes.base.RxPresenter;

/**
 * 景点收藏
 * Created by Ricky on 2017-5-26.
 */

public class TravelCollectionPresenter extends RxPresenter<TravelCollectionContract.View> implements TravelCollectionContract.Presenter {

    public TravelCollectionPresenter(TravelCollectionContract.View mView) {
        super(mView);
    }
}
