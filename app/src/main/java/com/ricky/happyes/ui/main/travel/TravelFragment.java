package com.ricky.happyes.ui.main.travel;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.loadmore.SwipeRefreshHelper;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseFragment;
import com.ricky.happyes.widgets.CustomErrorView;

import java.util.List;

import butterknife.BindView;

/**
 * 旅行
 * Created by Ricky on 2017-3-9.
 */

public class TravelFragment extends BaseFragment<TravelPresenter> implements TravelContract.View {

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.recycler_main_travel)
    RecyclerView mRecyclerViewList;
    @BindView(R.id.error_view)
    CustomErrorView mErrorView;

    private RecyclerAdapterWithHF mAdapterHF;
    private SwipeRefreshHelper mSwipeHelper;
    //    private List<TravelBean>
    private static final int PAGE_SIZE = 10;//页面大小
    private final int pageIndex = 1;//起始页面索引

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
        mSwipeRefresh.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        mSwipeHelper = new SwipeRefreshHelper(mSwipeRefresh);
    }

    @Override
    public void showError(String msg) {

    }
}
