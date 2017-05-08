package com.ricky.happyes.ui.main.home;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseFragment;
import com.ricky.happyes.bean.MyMessageListBean;
import com.ricky.happyes.bean.home.BannerBean;
import com.ricky.happyes.bean.home.HomeBean;
import com.ricky.happyes.util.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;

/**
 * homeFragment
 * Created by Ricky on 2017-3-9.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.swipe_home_refresh)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.nsv_home_container)
    NestedScrollView mAllContainer;
    @BindView(R.id.home_banner)
    Banner mBanner;
    @BindView(R.id.relative_person_show)
    RelativeLayout mRelativePersonShow;
    @BindView(R.id.relative_team_travel)
    RelativeLayout mRelativeTeamTravel;
    @BindView(R.id.tv_new_announcement)
    TextView mNewAnnouncement;
    @BindView(R.id.tv_new_announcement_time)
    TextView mNewAnnouncementTime;
    @BindView(R.id.tv_title_hot_travel)
    TextView mTitleHot;
    @BindView(R.id.recycler_main_hot_travel)
    RecyclerView mRecyclerHotView;

    private SwipeRefreshHelper mRefreshHelper;

    @Override
    public HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initEventAndData() {

        mRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mRefreshHelper = new SwipeRefreshHelper(mRefreshLayout);
        //自动加载
        mRefreshLayout.post(() -> mRefreshHelper.autoRefresh());
        //添加刷新操作
        mRefreshHelper.setOnSwipeRefreshListener(() -> {
            //获取首页banner
            mPresenter.getHomeBanner(getContext());
            //获取首页数据
            mPresenter.getHomeData(getContext());
        });

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerHotView.setLayoutManager(manager);
    }

    @Override
    public void onResume() {
        super.onResume();
        //解决fragment切换过程中导致recyclerview一直显示在顶部的问题
        mBanner.setFocusable(true);
        mBanner.setFocusableInTouchMode(true);
        mBanner.requestFocus();
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(getContext(), msg);
    }

    @Override
    public void onLoadBannerSuccess(List<BannerBean> list) {
        mRefreshHelper.refreshComplete();
        mBanner.setVisibility(View.VISIBLE);
        List<String> urls = new ArrayList<>();
        for (BannerBean bean : list) {
            urls.add(bean.getBanner_url());
        }
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);//设置banner样式
        mBanner.setImageLoader(new BannerGlideImageLoader());//设置图片加载器
        mBanner.setImages(urls);//设置图片集合
        mBanner.setBannerAnimation(Transformer.DepthPage);//设置动画效果
//        mBanner.setBannerTitles()//设置banner标题集合
        mBanner.isAutoPlay(true);//设置自动播放
        mBanner.setDelayTime(3000);//设置轮播时间
        mBanner.setIndicatorGravity(BannerConfig.CENTER);//设置banner指示器位置（如果存在指示器就设置）
        mBanner.start();//开启banner
    }

    @Override
    public void hideBanner() {
        mRefreshHelper.refreshComplete();
        mBanner.setVisibility(View.GONE);
    }

    @Override
    public void showHomeData(HomeBean bean) {
        //加载最新公告
        if (TextUtils.isEmpty(bean.getMessage_content())) {
            mNewAnnouncement.setText("暂时没有公告信息");
        } else {
            mNewAnnouncement.setText(bean.getMessage_content());
        }
        if (TextUtils.isEmpty(bean.getMessage_time())) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
            mNewAnnouncementTime.setText(sf.format(new Date()));
        } else {
            mNewAnnouncementTime.setText(bean.getMessage_time());
        }
        //加载最热景点
        if (bean.getHot_travel() == null || bean.getHot_travel().isEmpty()) {
            mTitleHot.setVisibility(View.GONE);
        } else {
            mTitleHot.setVisibility(View.VISIBLE);
            HotTravelAdapter mAdapter = new HotTravelAdapter(getContext(), bean.getHot_travel());
            mRecyclerHotView.setAdapter(mAdapter);
        }
    }
}
