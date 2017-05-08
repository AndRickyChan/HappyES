package com.ricky.happyes.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * RxPresenter
 * Created by Ricky on 2017-3-9.
 */

public abstract class RxPresenter<T extends BaseView> implements BasePresenter {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    public RxPresenter(T mView) {
        this.mView = mView;
    }

    protected void addSubscription(Subscription subscription) {
        if (mCompositeSubscription == null)
            mCompositeSubscription = new CompositeSubscription();
        mCompositeSubscription.add(subscription);
    }

    protected void unSubscription() {
        if (mCompositeSubscription != null)
            mCompositeSubscription.unsubscribe();
    }

    @Override
    public void detachView() {
        unSubscription();
    }
}
