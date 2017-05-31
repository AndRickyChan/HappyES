package com.ricky.happyes.ui.main.food.dining;

import android.support.v7.widget.Toolbar;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;

/**
 * 套餐列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopDiningActivity extends BaseActivity<ShopDiningPresenter> implements ShopDiningContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    public ShopDiningPresenter getPresenter() {
        return new ShopDiningPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_shop_dining;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);
    }
}
