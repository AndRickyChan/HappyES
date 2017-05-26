package com.ricky.happyes.ui.mine.collection.shop;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseFragment;
import com.ricky.happyes.util.ToastUtils;

/**
 * 店铺收藏
 * Created by Ricky on 2017-5-26.
 */

public class ShopCollectionFragment extends BaseFragment<ShopCollectionPresenter> implements ShopCollectionContract.View {
    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(getContext(),msg);
    }

    @Override
    public ShopCollectionPresenter getPresenter() {
        return new ShopCollectionPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_collection_shop;
    }

    @Override
    public void initEventAndData() {

    }
}
