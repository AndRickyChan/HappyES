package com.ricky.happyes.ui.main.food;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseFragment;
import com.ricky.happyes.bean.FoodTypeBean;
import com.ricky.happyes.bean.ShopListBean;
import com.ricky.happyes.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 美食
 * Created by Ricky on 2017-5-25.
 */

public class FoodFragment extends BaseFragment<FoodPresenter> implements FoodContract.View {

    private Context mContext;

    @BindView(R.id.recycler_food_type)
    RecyclerView mFoodTypeList;
    @BindView(R.id.swipe_food_refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.recycler_food_list)
    RecyclerView mShopContentList;

    private SwipeRefreshHelper mRefreshHelper;
    private RecyclerAdapterWithHF mAdapterHF;
    private int pageIndex = 1;//当前页面
    private static final int PAGE_SIZE = 10;//页面大小

    private String foodType = "";//美食类型
    private FoodTypeAdapter mFoodTypeAdapter;
    private List<FoodTypeBean> mFoodTypeListData = new ArrayList<>();//类型列表
    private List<ShopListBean.ShopBean> mShopListData = new ArrayList<>();//商家列表

    @Override
    public FoodPresenter getPresenter() {
        return new FoodPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_food;
    }

    @Override
    public void initEventAndData() {
        mContext = getContext();
        //设置刷新样式
        mRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mRefreshHelper = new SwipeRefreshHelper(mRefresh);
        //设置布局方式
        mFoodTypeList.setLayoutManager(new GridLayoutManager(mContext, 4, LinearLayoutManager.VERTICAL, false));
        mShopContentList.setLayoutManager(new LinearLayoutManager(mContext));
        mFoodTypeAdapter = new FoodTypeAdapter(mContext, mFoodTypeListData);
        mFoodTypeAdapter.setOnItemClickListener(new FoodTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position, String typeId) {
                foodType = typeId;
                pageIndex = 1;
                getFoodContentList(mContext, pageIndex, foodType);
                ToastUtils.toastShort(mContext, "点击的是" + position);
            }
        });
        mFoodTypeList.setAdapter(mFoodTypeAdapter);

        //设置商家列表
        ShopContentAdapter mShopAdapter = new ShopContentAdapter(mContext, mShopListData);
        mAdapterHF = new RecyclerAdapterWithHF(mShopAdapter);
        mShopContentList.setAdapter(mAdapterHF);

        //获取美食类型列表
        mPresenter.getFoodTypeList(mContext);
        //获取美食content列表
        mRefresh.post(() -> mRefreshHelper.autoRefresh());
        //刷新
        mRefreshHelper.setOnSwipeRefreshListener(new SwipeRefreshHelper.OnSwipeRefreshListener() {
            @Override
            public void onfresh() {
                pageIndex = 1;
                getFoodContentList(mContext, pageIndex, foodType);
            }
        });
        //加载更多
        mRefreshHelper.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void loadMore() {
                pageIndex++;
                getFoodContentList(mContext, pageIndex, foodType);
            }
        });
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(mContext, msg);
    }

    @Override
    public void onLoadFoodTypeSuccess(List<FoodTypeBean> list) {
        mFoodTypeListData.clear();
        mFoodTypeListData.addAll(list);
        mFoodTypeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFoodTypeError(int type) {
        // TODO: 2017-5-25 加载类型错误
    }

    @Override
    public void onLoadShopRefresh(List<ShopListBean.ShopBean> list) {
        mRefresh.setRefreshing(false);
        mShopListData.clear();
        mShopListData.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mRefreshHelper.refreshComplete();
        if (list.size() == PAGE_SIZE) {
            mRefreshHelper.setLoadMoreEnable(true);
        } else {
            mRefreshHelper.setLoadMoreEnable(false);
        }
    }

    @Override
    public void onLoadShopMore(List<ShopListBean.ShopBean> list) {
        mShopListData.addAll(list);
        mAdapterHF.notifyDataSetChangedHF();
        mRefreshHelper.loadMoreComplete(true);
    }

    @Override
    public void onRefreshError(int type) {

    }

    @Override
    public void onLoadMoreError(int type) {

    }

    /**
     * 获取美食列表
     */
    private void getFoodContentList(Context mContext, int page, String id) {
        mPresenter.getFoodContentList(mContext, page, PAGE_SIZE, id);
    }
}
