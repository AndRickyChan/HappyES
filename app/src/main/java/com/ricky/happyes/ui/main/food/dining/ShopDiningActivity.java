package com.ricky.happyes.ui.main.food.dining;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.bean.shopdetail.MealBean;
import com.ricky.happyes.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 套餐列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopDiningActivity extends BaseActivity<ShopDiningPresenter> implements ShopDiningContract.View {

    private Context mContext;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.swipe_dining_list)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.recycler_dining_list)
    RecyclerView mRecyclerDiningList;

    public static final String SHOP_ID = "shop_id";


    private SwipeRefreshHelper mSwipeRefreshHelper;
    private RecyclerAdapterWithHF mAdapterHF;
    private int pageIndex = 1;
    private static final int PAGE_SIZE = 10;
    private List<MealBean> mAllDining = new ArrayList<>();

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
        mContext = this;

        initToolbar(mToolbar);

        String shopId = getIntent().getStringExtra(SHOP_ID);

        mSwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mSwipeRefreshHelper = new SwipeRefreshHelper(mSwipeRefresh);

        mRecyclerDiningList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        DiningAdapter mAdapter = new DiningAdapter(this, mAllDining);
        mAdapterHF = new RecyclerAdapterWithHF(mAdapter);
        mRecyclerDiningList.setAdapter(mAdapterHF);

        mSwipeRefresh.post(() -> mSwipeRefreshHelper.autoRefresh());
        mSwipeRefreshHelper.setOnSwipeRefreshListener(new SwipeRefreshHelper.OnSwipeRefreshListener() {
            @Override
            public void onfresh() {
                //刷新
                pageIndex = 1;
                mPresenter.getDiningData(mContext, pageIndex, PAGE_SIZE, shopId);
            }
        });
        mSwipeRefreshHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                //加载更多
                pageIndex++;
                mPresenter.getDiningData(mContext, pageIndex, PAGE_SIZE, shopId);
            }
        });
    }

    @Override
    public void onLoadRefreshSuccess(List<MealBean> list) {
        mAllDining.clear();
        mAllDining.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mSwipeRefreshHelper.refreshComplete();
        mSwipeRefreshHelper.setLoadMoreEnable(list.size() == PAGE_SIZE);
    }

    @Override
    public void onLoadMoreSuccess(List<MealBean> list) {
        mAllDining.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mSwipeRefreshHelper.loadMoreComplete(true);
        mSwipeRefreshHelper.setLoadMoreEnable(list.size() == PAGE_SIZE);
    }

    @Override
    public void onRefreshError(int type) {

    }

    @Override
    public void onLoadMoreError(int type) {

    }
}
