package com.ricky.happyes.ui.setting.about;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.base.SimpleActivity;
import com.ricky.happyes.util.AppUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 关于
 * Created by Ricky on 2017-3-13.
 */

public class AboutActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_app_version)
    TextView mTvAppVersion;

    @Override
    public int getLayout() {
        return R.layout.activity_about;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);
        //设置APP版本
        mTvAppVersion.setText("Version " + AppUtils.getAppVersionName(this));
    }

    /**
     * 推薦給好友
     */
    @OnClick(R.id.relative_share_to_friends)
    public void shareToFriends() {
        // TODO: 2017-3-18 share
    }
}
