package com.ricky.happyes.ui.main.food.mealdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.mealdetail.MealMenuContentBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 套餐菜单适配器
 * Created by Ricky on 2017-6-1.
 */

public class MealMenuAdapter extends RecyclerView.Adapter {

    private List<MealMenuContentBean> list;
    private LayoutInflater mLayoutInflater;

    public MealMenuAdapter(Context mContext, List<MealMenuContentBean> list) {
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).isTitle()) {
            return 1;//标题
        } else {
            return 2;//内容
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new TitleViewHolder(mLayoutInflater.inflate(R.layout.item_meal_menu_title, parent, false));
        } else if (viewType == 2) {
            return new ContentViewHolder(mLayoutInflater.inflate(R.layout.item_meal_menu_content, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MealMenuContentBean bean = list.get(position);
        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).mTitle.setText(bean.getMenu_name());
        } else if (holder instanceof ContentViewHolder) {
            ContentViewHolder contentHolder = (ContentViewHolder) holder;
            contentHolder.mName.setText(bean.getMenu_name());
            contentHolder.mCount.setText(bean.getMenu_count());
            contentHolder.mPrice.setText("￥" + bean.getMenu_price());
        }
    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_meal_name)
        TextView mName;
        @BindView(R.id.tv_meal_count)
        TextView mCount;
        @BindView(R.id.tv_meal_price)
        TextView mPrice;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_meal_menu_title)
        TextView mTitle;

        public TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
