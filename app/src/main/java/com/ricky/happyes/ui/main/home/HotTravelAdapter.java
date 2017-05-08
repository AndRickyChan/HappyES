package com.ricky.happyes.ui.main.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.TravelBean;
import com.ricky.happyes.util.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 最热景点适配器
 * Created by Ricky on 2017-4-19.
 */

public class HotTravelAdapter extends RecyclerView.Adapter<HotTravelAdapter.ViewHolder> {

    private Context mContext;
    private List<TravelBean> mAllDatas;
    private LayoutInflater mLayoutInflater;

    public HotTravelAdapter(Context mContext, List<TravelBean> mAllDatas) {
        this.mContext = mContext;
        this.mAllDatas = mAllDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_travel, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TravelBean bean = mAllDatas.get(position);
        ImageUtils.getInstance().loadHotTravelItemImage(mContext, bean.getTravel_logo(), holder.mLogo);
        holder.mTitle.setText(bean.getTravel_title());
        holder.mContent.setText(bean.getTravel_des());
        holder.mGoodPoint.setText(String.valueOf(bean.getGood_point()));
        holder.mPrice.setText(String.valueOf(bean.getTravel_price()));
        if (position == mAllDatas.size() - 1) {
            holder.divider.setVisibility(View.GONE);
        } else {
            holder.divider.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mAllDatas == null ? 0 : mAllDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_one_day_scenc)
        ImageView mLogo;
        @BindView(R.id.tv_one_day_scenc_title)
        TextView mTitle;
        @BindView(R.id.tv_one_day_scenc_content)
        TextView mContent;
        @BindView(R.id.tv_one_day_good_point)
        TextView mGoodPoint;
        @BindView(R.id.tv_scenc_one_day_price)
        TextView mPrice;
        @BindView(R.id.view_item_travel_divider)
        View divider;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
