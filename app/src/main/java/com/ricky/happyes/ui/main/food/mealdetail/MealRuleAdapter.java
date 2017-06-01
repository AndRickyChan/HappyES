package com.ricky.happyes.ui.main.food.mealdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.mealdetail.MealRuleBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 套餐使用规则适配器
 * Created by Ricky on 2017-6-1.
 */

public class MealRuleAdapter extends RecyclerView.Adapter<MealRuleAdapter.ViewHolder> {

    private Context mContext;
    private List<MealRuleBean> list;
    private LayoutInflater mLayoutInflater;

    public MealRuleAdapter(Context mContext, List<MealRuleBean> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_meal_rule, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list == null || list.size() == 0) {
            holder.ruleContent.setText("无");
        } else {
            holder.ruleContent.setText(list.get(position).getRule_content());
        }
    }

    @Override
    public int getItemCount() {
        if (list == null || list.size() == 0) {
            return 1;
        } else {
            return list.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_meal_rule_content)
        TextView ruleContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
