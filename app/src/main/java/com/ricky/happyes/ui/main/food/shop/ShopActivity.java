package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.ricky.happyes.bean.shopdetail.AdviceMealBean;
import com.ricky.happyes.bean.shopdetail.ShopDetailBean;
import com.ricky.happyes.ui.main.food.comment.ShopCommentActivity;
import com.ricky.happyes.ui.main.food.dining.ShopDiningActivity;
import com.ricky.happyes.util.ImageUtils;
import com.ricky.happyes.util.ToastUtils;

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
    @BindView(R.id.tv_recomand_food_list)
    TextView mRecomandMeal;


    public static final String SHOP_ID = "shop_id";//店铺ID
    public static final String SHOP_TITLE = "shop_title";//店铺名称

    private String shopId = "";
    private String shopPhone = "";


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

        mPresenter.getShopDetailData(this, shopId);
    }

    @Override
    public void onLoadDataSuccess(ShopDetailBean bean) {

        shopPhone = bean.getShop_phone();
        ImageUtils.getInstance().loadShopBgLogoImage(this, bean.getShop_bg_logo(), mShopBgLogo);
        mCibCollection.setChecked(bean.isCollection());
        mStar.setRating(bean.getShop_star());
        mAveragePrice.setText(bean.getShop_average_price() + "元/人");
        mAddress.setText(bean.getShop_address());

        //填充推荐菜
        if (bean.getAdviceMealList() != null && bean.getAdviceMealList().size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (AdviceMealBean bean1 : bean.getAdviceMealList()) {
                builder.append(bean1.getName()).append("  ");
            }
            mRecomandMeal.setText(builder.toString().trim());
        }

        //填充堂食套餐
        if (bean.getMealList() != null && bean.getMealList().size() > 0) {
            mRecyclerMeal.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            ShopMealAdapter mAdapter = new ShopMealAdapter(mContext, bean.getMealList());
            mRecyclerMeal.setAdapter(mAdapter);
        }

        //填充评论
        if (bean.getCommentBeanList() != null && bean.getCommentBeanList().size() > 0) {
            mRecyclerComment.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            ShopCommentAdapter mAdapter = new ShopCommentAdapter(mContext, bean.getCommentBeanList());
            mRecyclerComment.setAdapter(mAdapter);
        }

    }

    /**
     * 收藏
     */
    @OnClick(R.id.cib_collection)
    public void onCollectionClicked() {
        mCibCollection.setChecked(!mCibCollection.isChecked());
    }

    /**
     * 查看所有评论
     */
    @OnClick(R.id.relative_all_comment)
    public void onAllCommentClicked() {
        Intent mIntent = new Intent(this, ShopCommentActivity.class);
        mIntent.putExtra(ShopCommentActivity.SHOP_ID, shopId);
        startActivity(mIntent);
    }

    /**
     * 查看所有套餐
     */
    @OnClick(R.id.tv_dining_meal_more)
    public void onAllDiningClicked() {
        Intent mIntent = new Intent(this, ShopDiningActivity.class);
        mIntent.putExtra(ShopDiningActivity.SHOP_ID, shopId);
        startActivity(mIntent);
    }

    /**
     * 拨打电话
     */
    @OnClick(R.id.iv_shop_phone)
    public void onPhoneClicked() {
        if (shopPhone != null && !"".equals(shopPhone)) {
            Intent mIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + shopPhone));
            startActivity(mIntent);
        } else {
            showError("商家电话为空");
        }
    }
}
