package com.ricky.happyes.ui.resetpass;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;

/**
 * 重置密码
 * Created by Ricky on 2017-4-11.
 */

public class ResetPassActivity extends BaseActivity<ResetPassPresenter> implements ResetPassContract.View {
    @Override
    public void showError(String msg) {

    }

    @Override
    public ResetPassPresenter getPresenter() {
        return new ResetPassPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_reset_pass;
    }

    @Override
    public void initEventAndData() {

    }
}
