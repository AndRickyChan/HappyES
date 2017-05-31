package com.ricky.happyes.ui.main.food.comment;

import android.support.v7.widget.Toolbar;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;

/**
 * 评论列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopCommentActivity extends BaseActivity<ShopCommentPresenter> implements ShopCommentContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    public static final String SHOP_ID = "shop_id";

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    public ShopCommentPresenter getPresenter() {
        return new ShopCommentPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_shop_comment;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);
        String shopId = getIntent().getStringExtra(SHOP_ID);
    }
}
