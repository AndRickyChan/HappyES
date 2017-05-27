package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;
import android.support.design.widget.CheckableImageButton;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.bean.MealBean;
import com.ricky.happyes.bean.ShopCommentBean;
import com.ricky.happyes.util.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 店铺详情
 * Created by Ricky on 2017-5-27.
 */

public class ShopActivity extends BaseActivity<ShopPresenter> implements ShopContract.View {

    private Context mContext;

    @BindView(R.id.iv_shop_background)
    ImageView mShopBgLogo;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ctl_header_container)
    CollapsingToolbarLayout mToolbarContainer;
    @BindView(R.id.cib_collection)
    CheckableImageButton mCibCollection;
    @BindView(R.id.tv_shop_star)
    AppCompatRatingBar mStar;
    @BindView(R.id.tv_shop_average_price)
    TextView mAveragePrice;
    @BindView(R.id.tv_shop_location)
    TextView mAddress;
    @BindView(R.id.iv_shop_phone)
    ImageView mPhone;
    @BindView(R.id.recycler_dining_meal)
    RecyclerView mRecyclerMeal;
    @BindView(R.id.tv_dining_meal_more)
    TextView mMealMore;
    @BindView(R.id.recycler_user_comment)
    RecyclerView mRecyclerComment;

    public static final String SHOP_ID = "shop_id";//店铺ID
    public static final String SHOP_TITLE = "shop_title";//店铺名称

    private String shopId = "";


    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    public ShopPresenter getPresenter() {
        return new ShopPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_shop;
    }

    @Override
    public void initEventAndData() {
        mContext = this;
        initToolbar(mToolbar);
        shopId = getIntent().getStringExtra(SHOP_ID);//获取店铺ID
        //设置店铺名称
        String shopTitle = getIntent().getStringExtra(SHOP_TITLE);
        if (shopTitle != null && !"".equals(shopTitle)) {
            mToolbarContainer.setTitle(shopTitle);
        } else {
            mToolbarContainer.setTitle("店铺详情");
        }

        mPresenter.getMealList(this, shopId);
        mPresenter.getCommentList(this, shopId);
    }

    @Override
    public void onMealListSuccess(List<MealBean> list) {
        mRecyclerMeal.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        ShopMealAdapter mAdapter = new ShopMealAdapter(mContext, list);
        mRecyclerMeal.setAdapter(mAdapter);
    }

    @Override
    public void onCommentListSuccess(List<ShopCommentBean> list) {
        mRecyclerComment.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        ShopCommentAdapter mAdapter = new ShopCommentAdapter(mContext, list);
        mRecyclerComment.setAdapter(mAdapter);
    }

    @OnClick(R.id.cib_collection)
    public void onCollectionClicked() {
        mCibCollection.setChecked(!mCibCollection.isChecked());
    }
}
