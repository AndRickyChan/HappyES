package com.ricky.happyes.ui.setting;

import android.content.Intent;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.ui.login.LoginActivity;
import com.ricky.happyes.ui.setting.about.AboutActivity;
import com.ricky.happyes.ui.setting.feedback.FeedBackActivity;
import com.ricky.happyes.util.AppManager;
import com.ricky.happyes.util.DataCleanUtils;
import com.ricky.happyes.util.SPUtils;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置
 * Created by Ricky on 2017-3-13.
 */

public class SettingActivity extends BaseActivity<SettingPresenter> implements SettingContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_cache_count)
    TextView mTvCacheSize;
    @BindView(R.id.tv_setting_accept_push)
    SwitchCompat mPushSwitch;

    @Override
    public SettingPresenter getPresenter() {
        return new SettingPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_setting;
    }

    @Override
    public void initEventAndData() {

        initToolbar(mToolbar);
        //初始化是否接收推送消息
        boolean isAcceptPush = (boolean) SPUtils.get(this, Constants.ACCEPT_PUSH_MESSAGE, true);
        mPushSwitch.setChecked(isAcceptPush);

        //初始化缓存大小
        try {
            setCacheSize(DataCleanUtils.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
            setCacheSize("0.00MB");
        }
    }

    @Override
    public void setCacheSize(String cache) {
        mTvCacheSize.setText(cache);
    }

    @Override
    public void logoutSuccess() {
        //结束掉所有的后台activity
        AppManager.getInstance().finishAllActivity();
        //跳转到登录界面
        Intent mIntent = new Intent(this, LoginActivity.class);
        startActivity(mIntent);
    }

    /**
     * 更新切换推送后的显示UI
     *
     * @param isPush 是否接收推送
     */
    @Override
    public void updatePushStatusUI(boolean isPush) {
        mPushSwitch.setChecked(isPush);
    }

    /**
     * 是否接收推送
     */
    @OnClick(R.id.relative_switch_push)
    public void switchPush() {
        mPresenter.changePushStatus(this, mPushSwitch.isChecked());
    }

    /**
     * 意见反馈
     */
    @OnClick(R.id.relative_feed_back)
    public void toFeedBack() {
        startActivity(new Intent(this, FeedBackActivity.class));
    }

    /**
     * 关于
     */
    @OnClick(R.id.relative_about)
    public void toAbout() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    /**
     * 清除缓存
     */
    @OnClick(R.id.relative_clear_cache)
    public void clearCache() {
        mPresenter.clearCache(this);
    }

    /**
     * 退出登录
     */
    @OnClick(R.id.btn_setting_log_out)
    public void logout() {
        mPresenter.logout(this);
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }
}
