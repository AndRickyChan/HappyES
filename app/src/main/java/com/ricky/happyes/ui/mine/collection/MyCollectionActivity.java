package com.ricky.happyes.ui.mine.collection;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.ricky.happyes.R;
import com.ricky.happyes.base.SimpleActivity;

import butterknife.BindView;

/**
 * 我的收藏
 * Created by Ricky on 2017-5-24.
 */

public class MyCollectionActivity extends SimpleActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tl_my_collection)
    TabLayout mTabLayout;
    @BindView(R.id.vp_my_collection)
    ViewPager mViewPager;

    @Override
    public int getLayout() {
        return R.layout.activity_my_collection;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);
        MyCollectionVPAdapter mAdapter = new MyCollectionVPAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
