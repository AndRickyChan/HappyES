package com.ricky.happyes.ui.main.travel.detail;

import android.content.Context;
import android.support.design.widget.CheckableImageButton;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.bean.traveldetail.TravelDetailBean;
import com.ricky.happyes.util.ImageUtils;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;

/**
 * 景点详情
 * Created by Ricky on 2017-6-19.
 */

public class TravelDetailActivity extends BaseActivity<TravelDetailPresenter> implements TravelDetailContract.View {

    @BindView(R.id.ctbl_travel_detail)
    CollapsingToolbarLayout mCollsToolbar;
    @BindView(R.id.iv_travel_detail_header)
    ImageView mDetailHeader;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.cib_collection)
    CheckableImageButton mCollectTravel;
    @BindView(R.id.linear_travel_location)
    LinearLayout mLinearLocationContainer;
    @BindView(R.id.tv_travel_location)
    TextView mTvLocation;
    @BindView(R.id.linear_comment_container)
    LinearLayout mCommentContainer;
    @BindView(R.id.rating_travel_star)
    AppCompatRatingBar mStar;
    @BindView(R.id.tv_travel_comment_count)
    TextView mCommentCount;
    @BindView(R.id.recycler_travel_price)
    RecyclerView mRecyclerPrice;
    @BindView(R.id.recycler_travel_advice)
    RecyclerView mRecyclerAdvice;

    private Context mContext;
    public static final String TRAVEL_ID = "travel_id";//景点ID
    public static final String TRAVEL_TITLE = "travel_title";//景点名称
    private String travelId = "";


    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    public TravelDetailPresenter getPresenter() {
        return new TravelDetailPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_travel_detail;
    }

    @Override
    public void initEventAndData() {
        mContext = this;

        initToolbar(mToolbar);
        //设置标题
        String travelTitle = getIntent().getStringExtra(TRAVEL_TITLE);
        if (TextUtils.isEmpty(travelTitle)) {
            mCollsToolbar.setTitle("景点详情");
        } else {
            mCollsToolbar.setTitle(travelTitle);
        }

        //拿到景点的ID进行详情数据的获取
        travelId = getIntent().getStringExtra(TRAVEL_ID);
        if (!TextUtils.isEmpty(travelId)) {
            mPresenter.getTravelDetail(this, travelId);
        } else {
            // TODO: 2017-6-19 显示错误信息
        }
        //设置门票价格列表模式
        mRecyclerPrice.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerAdvice.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onLoadTravelDetailSuccess(TravelDetailBean bean) {
        ImageUtils.getInstance().loadTravelBgLogoImage(this, bean.getTravel_bg(), mDetailHeader);
        mCollectTravel.setChecked(bean.is_collect());
        mTvLocation.setText(bean.getTravel_location());
        mStar.setRating(bean.getTravel_star());
        mCommentCount.setText(bean.getComment_count() + " 条评论");
        mRecyclerPrice.setAdapter(new TravelDetailPriceAdapter(this, bean.getPrice_list()));
        mRecyclerAdvice.setAdapter(new TravelDetailAdviceAdapter(this, bean.getAdvice_list()));

        //查看地图
        mLinearLocationContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017-6-19 百度地图
                ToastUtils.toastShort(mContext, "集成百度地图");
            }
        });

        //跳转到评论详情
        mCommentContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017-6-19 评论详情
                ToastUtils.toastShort(mContext, "跳转到评论界面");
            }
        });
    }

    @Override
    public void onLoadTravelDetailError(int type) {

    }
}
