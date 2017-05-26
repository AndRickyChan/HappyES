package com.ricky.happyes.ui.mine.collection.travel;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseFragment;
import com.ricky.happyes.util.ToastUtils;

/**
 * 景点收藏
 * Created by Ricky on 2017-5-26.
 */

public class TravelCollectionFragment extends BaseFragment<TravelCollectionPresenter> implements TravelCollectionContract.View {

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(getContext(), msg);
    }

    @Override
    public TravelCollectionPresenter getPresenter() {
        return new TravelCollectionPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_collection_travel;
    }

    @Override
    public void initEventAndData() {

    }
}
