package com.ricky.happyes.ui.main.food;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.FoodTypeBean;
import com.ricky.happyes.util.ImageUtils;
import com.ricky.happyes.widgets.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 美食类型适配器
 * Created by Ricky on 2017-5-25.
 */

public class FoodTypeAdapter extends RecyclerView.Adapter<FoodTypeAdapter.ViewHolder> {

    private Context mContext;
    private List<FoodTypeBean> list;
    private LayoutInflater mLayoutInflater;

    private OnItemClickListener onItemClickListener;

    public FoodTypeAdapter(Context mContext, List<FoodTypeBean> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_food_type, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageUtils.getInstance().loadFoodTypeImage(mContext, list.get(position).getType_logo(), holder.typeLogo);
        holder.typeName.setText(list.get(position).getType_name());
        if (list.get(position).isSelected()) {
            holder.typeName.setTextColor(mContext.getResources().getColor(R.color.colorPrimary));
        } else {
            holder.typeName.setTextColor(Color.parseColor("#ff222222"));
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_type_logo)
        CircleImageView typeLogo;
        @BindView(R.id.tv_type_name)
        TextView typeName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClickListener(getAdapterPosition(), list.get(getAdapterPosition()).getType_id());
                    }
                    setAllFalse();
                    list.get(getAdapterPosition()).setSelected(true);
                    notifyDataSetChanged();
                }
            });
        }
    }

    public void setOnItemClickListener(OnItemClickListener callback) {
        this.onItemClickListener = callback;
    }

    public interface OnItemClickListener {
        void onItemClickListener(int position, String typeId);
    }

    private void setAllFalse() {
        for (FoodTypeBean bean : list) {
            bean.setSelected(false);
        }
    }
}
