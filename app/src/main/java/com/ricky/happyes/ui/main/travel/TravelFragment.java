package com.ricky.happyes.ui.main.travel;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseFragment;
import com.ricky.happyes.bean.TravelBean;
import com.ricky.happyes.util.ToastUtils;
import com.ricky.happyes.widgets.CustomErrorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 旅行
 * Created by Ricky on 2017-3-9.
 */

public class TravelFragment extends BaseFragment<TravelPresenter> implements TravelContract.View {

    private Context mContext;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.recycler_main_travel)
    RecyclerView mRecyclerViewList;
    @BindView(R.id.error_view)
    CustomErrorView mErrorView;

    private RecyclerAdapterWithHF mAdapterHF;
    private SwipeRefreshHelper mSwipeHelper;
    private List<TravelBean> mAllDatas = new ArrayList<>();//所有数据
    private static final int PAGE_SIZE = 10;//页面大小
    private int pageIndex = 1;//起始页面索引

    @Override
    public TravelPresenter getPresenter() {
        return new TravelPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_travel;
    }

    @Override
    public void initEventAndData() {
        mContext = getContext();

        mSwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mSwipeHelper = new SwipeRefreshHelper(mSwipeRefresh);

        mRecyclerViewList.setLayoutManager(new LinearLayoutManager(mContext));
        TravelAdapter travelAdapter = new TravelAdapter(mContext, mAllDatas);
        mAdapterHF = new RecyclerAdapterWithHF(travelAdapter);
        mRecyclerViewList.setAdapter(mAdapterHF);
        //自动加载
        mSwipeRefresh.post(() -> mSwipeHelper.autoRefresh());
        //刷新
        mSwipeHelper.setOnSwipeRefreshListener(new SwipeRefreshHelper.OnSwipeRefreshListener() {
            @Override
            public void onfresh() {
                pageIndex = 1;
                mPresenter.getTravelList(mContext, pageIndex, PAGE_SIZE);
            }
        });
        //加载更多
        mSwipeHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                pageIndex++;
                mPresenter.getTravelList(mContext, pageIndex, PAGE_SIZE);
            }
        });
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(mContext, msg);
    }

    @Override
    public void onLoadRefresh(List<TravelBean> list) {
        mSwipeRefresh.setRefreshing(false);
        mErrorView.setVisibility(View.GONE);
        mAllDatas.clear();
        mAllDatas.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mSwipeHelper.refreshComplete();
        if (list.size() == PAGE_SIZE) {
            mSwipeHelper.setLoadMoreEnable(true);
        } else {
            mSwipeHelper.setLoadMoreEnable(false);
        }
    }

    @Override
    public void onLoadMore(List<TravelBean> list) {
        mAllDatas.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mSwipeHelper.loadMoreComplete(true);
    }

    @Override
    public void onLoadError(int type) {
        mSwipeHelper.refreshComplete();
        mErrorView.setErrorType(type);
    }

    @Override
    public void onNoMore() {
        mSwipeHelper.loadMoreComplete(true);
        mSwipeHelper.setLoadMoreEnable(false);
    }
}
