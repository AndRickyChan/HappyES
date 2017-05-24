package com.ricky.happyes.ui.mine.msg;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.bean.MyMessageListBean;
import com.ricky.happyes.util.ToastUtils;
import com.ricky.happyes.widgets.CustomErrorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 我的消息
 * Created by Ricky on 2017-3-14.
 */

public class MyMessageActivity extends BaseActivity<MyMessagePresenter> implements MyMessageContract.View {

    private Context mContext;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.recycler_my_message)
    RecyclerView mRecyclerView;
    @BindView(R.id.error_view)
    CustomErrorView mErrorView;

    private RecyclerAdapterWithHF mAdapterHF;
    private SwipeRefreshHelper mSwipeRefreshHelper;
    private List<MyMessageListBean.MyMessage> messageList = new ArrayList<>();
    private static final int PAGE_SIZE = 10;
    private int pageIndex = 1;

    @Override
    public MyMessagePresenter getPresenter() {
        return new MyMessagePresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_my_message;
    }

    @Override
    public void initEventAndData() {
        mContext = this;
        initToolbar(mToolbar);
        mSwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyMessageAdapter mAdapter = new MyMessageAdapter(this, messageList);
        mAdapterHF = new RecyclerAdapterWithHF(mAdapter);
        mRecyclerView.setAdapter(mAdapterHF);
        mSwipeRefreshHelper = new SwipeRefreshHelper(mSwipeRefresh);

        mSwipeRefresh.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshHelper.autoRefresh();
            }
        });

        //刷新
        mSwipeRefreshHelper.setOnSwipeRefreshListener(new SwipeRefreshHelper.OnSwipeRefreshListener() {
            @Override
            public void onfresh() {
                pageIndex = 1;
                mPresenter.getMyMessage(mContext, pageIndex, PAGE_SIZE);
            }
        });

        //加载更多
        mSwipeRefreshHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                pageIndex++;
                mPresenter.getMyMessage(mContext, pageIndex, PAGE_SIZE);
            }
        });
    }

    @Override
    public void onRefreshData(List<MyMessageListBean.MyMessage> list) {
        mSwipeRefresh.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
        messageList.clear();
        messageList.addAll(list);
        mAdapterHF.notifyDataSetChanged();
        mSwipeRefreshHelper.refreshComplete();
        mSwipeRefreshHelper.setLoadMoreEnable(true);
    }

    @Override
    public void onLoadMoreData(List<MyMessageListBean.MyMessage> list) {
        messageList.addAll(list);
        mAdapterHF.notifyDataSetChanged();
        mSwipeRefreshHelper.loadMoreComplete(true);
    }

    @Override
    public void onRefreshError(int type) {
        mSwipeRefreshHelper.loadMoreComplete(true);
        mSwipeRefresh.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.setErrorType(type);
    }

    @Override
    public void onLoadMoreError(int type) {
        switch (type) {
            case CustomErrorView.ERROR_TYPE_EMPTY:
                mSwipeRefreshHelper.setNoMoreData();
                mSwipeRefreshHelper.setLoadMoreEnable(false);
                break;
            case CustomErrorView.ERROR_TYPE_ERROR:
                mSwipeRefreshHelper.loadMoreComplete(true);
                break;
            case CustomErrorView.ERROR_TYPE_NET_ERROR:
                mSwipeRefreshHelper.loadMoreComplete(true);
                break;
        }
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }
}
