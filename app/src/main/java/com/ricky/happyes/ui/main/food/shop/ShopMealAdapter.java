package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.shopdetail.MealBean;
import com.ricky.happyes.ui.main.food.mealdetail.MealDetailActivity;
import com.ricky.happyes.util.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 套餐适配器
 * Created by Ricky on 2017-5-27.
 */

public class ShopMealAdapter extends RecyclerView.Adapter<ShopMealAdapter.ViewHolder> {

    private Context mContext;
    private List<MealBean> list;
    private LayoutInflater mLayoutInflater;

    public ShopMealAdapter(Context mContext, List<MealBean> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_shop_meal, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MealBean bean = list.get(position);
        ImageUtils.getInstance().loadMealLogoImage(mContext, bean.getMeal_logo(), holder.mealLogo);
        holder.mealName.setText(bean.getMeal_name());
        holder.mealDay.setText(bean.getMeal_day());
        holder.mealPreDate.setText(bean.isNeed_predate() ? "提前预约" : "免预约");
        holder.mealPrice.setText(String.valueOf(bean.getMeal_price()));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_meal_logo)
        ImageView mealLogo;
        @BindView(R.id.tv_meal_title)
        TextView mealName;
        @BindView(R.id.tv_meal_day)
        TextView mealDay;
        @BindView(R.id.tv_meal_need_predate)
        TextView mealPreDate;
        @BindView(R.id.tv_meal_price)
        TextView mealPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            /**
             * 点击进入详情
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mIntent = new Intent(mContext, MealDetailActivity.class);
                    mIntent.putExtra(MealDetailActivity.MEAL_ID, list.get(getAdapterPosition()).getMeal_id());
                    mIntent.putExtra(MealDetailActivity.MEAL_TITLE, list.get(getAdapterPosition()).getMeal_name());
                    mContext.startActivity(mIntent);
                }
            });
        }
    }
}
