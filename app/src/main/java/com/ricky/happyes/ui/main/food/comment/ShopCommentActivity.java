package com.ricky.happyes.ui.main.food.comment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.ricky.happyes.R;
import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.bean.shopdetail.ShopCommentBean;
import com.ricky.happyes.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 评论列表
 * Created by Ricky on 2017-5-31.
 */

public class ShopCommentActivity extends BaseActivity<ShopCommentPresenter> implements ShopCommentContract.View {

    private Context mContext;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.swipe_comment_list)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.recycler_comment_list)
    RecyclerView mRecyclerCommmentList;

    private SwipeRefreshHelper mSwipeHelper;
    private RecyclerAdapterWithHF mAdapterHF;
    private int pageIndex = 1;
    private List<ShopCommentBean> mAllComments = new ArrayList<>();


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
        mContext = this;

        String shopId = getIntent().getStringExtra(SHOP_ID);

        initToolbar(mToolbar);
        mSwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mSwipeHelper = new SwipeRefreshHelper(mSwipeRefresh);

        mRecyclerCommmentList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        CommentAdapter mAdapter = new CommentAdapter(this, mAllComments);
        mAdapterHF = new RecyclerAdapterWithHF(mAdapter);
        mRecyclerCommmentList.setAdapter(mAdapterHF);

        mSwipeRefresh.post(() -> mSwipeHelper.autoRefresh());

        mSwipeHelper.setOnSwipeRefreshListener(new SwipeRefreshHelper.OnSwipeRefreshListener() {
            @Override
            public void onfresh() {
                //刷新
                pageIndex = 1;
                mPresenter.getCommentList(mContext, pageIndex, Constants.PAGE_SIZE, shopId);
            }
        });
        mSwipeHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                //加载更多
                pageIndex++;
                mPresenter.getCommentList(mContext, pageIndex, Constants.PAGE_SIZE, shopId);
            }
        });
    }

    @Override
    public void onRefreshSuccess(List<ShopCommentBean> list) {
        mAllComments.clear();
        mAllComments.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mSwipeHelper.refreshComplete();
        mSwipeHelper.setLoadMoreEnable(list.size() == Constants.PAGE_SIZE);
    }

    @Override
    public void onLoadMoreSuccess(List<ShopCommentBean> list) {
        mAllComments.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mSwipeHelper.loadMoreComplete(true);
        mSwipeHelper.setLoadMoreEnable(list.size() == Constants.PAGE_SIZE);
    }

    @Override
    public void onRefreshError(int type) {

    }

    @Override
    public void onLoadMoreError(int type) {

    }
}
