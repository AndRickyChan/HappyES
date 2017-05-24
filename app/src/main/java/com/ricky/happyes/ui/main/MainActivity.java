package com.ricky.happyes.ui.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.bean.UserBean;
import com.ricky.happyes.ui.main.home.HomeFragment;
import com.ricky.happyes.ui.main.notifications.NotificationsFragment;
import com.ricky.happyes.ui.main.travel.TravelFragment;
import com.ricky.happyes.ui.mine.msg.MyMessageActivity;
import com.ricky.happyes.ui.setting.SettingActivity;
import com.ricky.happyes.util.AppManager;
import com.ricky.happyes.util.ImageUtils;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements BottomNavigationView.OnNavigationItemSelectedListener
        , NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    @BindView(R.id.main_drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.main_navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.main_bottom_navigation_view)
    BottomNavigationView mBottomNavigation;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private ImageView mIvHeader;
    private TextView mTvNickName;

    private long mExitTime = 0;
    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private TravelFragment travelFragment;
    private NotificationsFragment notificationsFragment;

    private boolean isSuccess = false;//是否获取个人信息成功

    @Override
    public MainPresenter getPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initEventAndData() {

        fragmentManager = getSupportFragmentManager();

        initToolbar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout
                , R.string.hint_main_open_toggle, R.string.hint_main_close_toggle);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //设置底部导航栏点击监听事件
        mBottomNavigation.setOnNavigationItemSelectedListener(this);
        //设置左侧导航栏点击监听事件
        mNavigationView.setNavigationItemSelectedListener(this);
        //加载左侧导航头部
        View leftRootView = LayoutInflater.from(this).inflate(R.layout.layout_main_left_header, mNavigationView, false);
        //找到左侧导航头部组件
        mIvHeader = (ImageView) leftRootView.findViewById(R.id.iv_user_header);
        mTvNickName = (TextView) leftRootView.findViewById(R.id.tv_user_nickname);
        mNavigationView.addHeaderView(leftRootView);
        //添加header点击事件
        mIvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isSuccess) {
                    //如果获取个人信息成功，则跳转到个人信息界面

                } else {
                    //如果获取个人信息失败,则重新获取

                }
            }
        });
        //默认显示首页
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        showFragment(transaction, R.id.bottom_navigation_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (item.getItemId()) {
            //底部导航
            case R.id.bottom_navigation_home://主页
                showFragment(transaction, R.id.bottom_navigation_home);
                return true;
            case R.id.bottom_navigation_travel://旅行
                showFragment(transaction, R.id.bottom_navigation_travel);
                return true;
            case R.id.bottom_navigation_notifications://公告
                showFragment(transaction, R.id.bottom_navigation_notifications);
                return true;
            //左侧导航点击
            case R.id.menu_my_attention://我的关注
                mDrawerLayout.closeDrawers();

                return true;
            case R.id.menu_my_route://我的线路
                mDrawerLayout.closeDrawers();

                return true;
            case R.id.menu_my_message://我的消息
                mDrawerLayout.closeDrawers();
                startActivity(new Intent(this, MyMessageActivity.class));
                return true;
            case R.id.menu_setting://设置
                mDrawerLayout.closeDrawers();
                startActivity(new Intent(this, SettingActivity.class));
                return true;
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }
        if (System.currentTimeMillis() - mExitTime > 2000) {
            ToastUtils.toastShort(this, "请再按一下退出程序");
            mExitTime = System.currentTimeMillis();
        } else {
            AppManager.getInstance().exitApp();
        }
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (homeFragment != null)
            transaction.hide(homeFragment);
        if (travelFragment != null)
            transaction.hide(travelFragment);
        if (notificationsFragment != null)
            transaction.hide(notificationsFragment);
    }

    private void showFragment(FragmentTransaction transaction, int resId) {
        hideAllFragment(transaction);
        switch (resId) {
            case R.id.bottom_navigation_home://首页
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.main_content, homeFragment, "homeFragment");
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case R.id.bottom_navigation_travel://旅行
                if (travelFragment == null) {
                    travelFragment = new TravelFragment();
                    transaction.add(R.id.main_content, travelFragment, "travelFragment");
                } else {
                    transaction.show(travelFragment);
                }
                break;
            case R.id.bottom_navigation_notifications://公告
                if (notificationsFragment == null) {
                    notificationsFragment = new NotificationsFragment();
                    transaction.add(R.id.main_content, notificationsFragment, "notificationsFragment");
                } else {
                    transaction.show(notificationsFragment);
                }
                break;
        }
        transaction.commit();
    }

    @Override
    public void onLoadUserInfoSuccess(UserBean bean) {
        isSuccess = true;
        //设置用户头像
        ImageUtils.getInstance().loadPortraitHeader(this, bean.getUserHeaderUrl(), mIvHeader);
        //设置用户昵称
        mTvNickName.setText(bean.getNickName());
    }

    @Override
    public void onLoadUserInfoError() {
        isSuccess = false;

        mIvHeader.setImageResource(R.drawable.ic_default_user_portrait);
        mTvNickName.setText("获取个人信息失败");
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }
}
