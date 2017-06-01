package com.ricky.happyes.ui.main.food.mealdetail;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.bean.mealdetail.MealDetailBean;
import com.ricky.happyes.bean.mealdetail.MealMenuBean;
import com.ricky.happyes.bean.mealdetail.MealMenuContentBean;
import com.ricky.happyes.util.ImageUtils;
import com.ricky.happyes.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 套餐详情
 * Created by Ricky on 2017-6-1.
 */

public class MealDetailActivity extends BaseActivity<MealDetailPresenter> implements MealDetailContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.meal_detal_cl_toolbar)
    CollapsingToolbarLayout mClToolbarLayout;
    @BindView(R.id.iv_meal_detail_background)
    ImageView mMealBg;
    @BindView(R.id.tv_meal_price)
    TextView mMealPrice;
    @BindView(R.id.btn_predate_now)
    Button mBtnPreDate;
    @BindView(R.id.recycler_meal_detail)
    RecyclerView mRecyclerMealDetail;
    @BindView(R.id.tv_meal_work_date)
    TextView mMealWorkDate;//有效期
    @BindView(R.id.tv_meal_use_time)
    TextView mMealUseTime;//使用时间
    @BindView(R.id.recycler_meal_use_rule)
    RecyclerView mMealRules;//使用规则


    public static final String MEAL_ID = "meal_id";//套餐ID
    public static final String MEAL_TITLE = "meal_title";//套餐名称

    private String mealId = "";//套餐ID
    private String shopPhone = "";//店铺电话

    @Override
    public MealDetailPresenter getPresenter() {
        return new MealDetailPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_meal_detial;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);

        mealId = getIntent().getStringExtra(MEAL_ID);
        String mealTitle = getIntent().getStringExtra(MEAL_TITLE);
        if (TextUtils.isEmpty(mealTitle)) {
            mClToolbarLayout.setTitle("套餐详情");
        } else {
            mClToolbarLayout.setTitle(mealTitle);
        }

        mRecyclerMealDetail.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMealRules.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        /**
         * 获取数据
         */
        mPresenter.getCommonMealData(this, mealId);
        mPresenter.getMealMenuData(this, mealId);
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }


    @Override
    public void onLoadCommonDataSuccess(MealDetailBean bean) {
        ImageUtils.getInstance().loadMealBgLogoImage(this, bean.getMeal_bg(), mMealBg);
        mMealPrice.setText(bean.getMeal_price() + "");
        shopPhone = bean.getShop_phone();
        mBtnPreDate.setEnabled(!TextUtils.isEmpty(shopPhone));
        mMealWorkDate.setText(bean.getMeal_work_date());
        mMealUseTime.setText(bean.getMeal_use_day());
        mMealRules.setAdapter(new MealRuleAdapter(this, bean.getRuleList()));
    }

    @Override
    public void onLoadMealMenuSuccess(List<MealMenuBean> list) {
        List<MealMenuContentBean> mAllDatas = new ArrayList<>();
        for (MealMenuBean menuBean : list) {
            mAllDatas.add(new MealMenuContentBean(menuBean.getTitle(), "", 0, true));
            for (MealMenuContentBean contentBean : menuBean.getList()) {
                mAllDatas.add(contentBean);
            }
        }
        mRecyclerMealDetail.setAdapter(new MealMenuAdapter(this, mAllDatas));
    }

    /**
     * 点击立即预定
     */
    @OnClick(R.id.btn_predate_now)
    public void preDateClicked() {
        if (!TextUtils.isEmpty(shopPhone)) {
            Intent mIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + shopPhone));
            startActivity(mIntent);
        } else {
            showError("商家没留下电话");
        }
    }
}
