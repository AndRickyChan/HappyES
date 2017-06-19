package com.ricky.happyes.ui.main.travel.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.traveldetail.PriceBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 景点详情价格适配器
 * Created by Ricky on 2017-6-19.
 */

public class TravelDetailPriceAdapter extends RecyclerView.Adapter<TravelDetailPriceAdapter.ViewHolder> {

    private List<PriceBean> mAllDatas;
    private LayoutInflater mLayoutInflater;

    public TravelDetailPriceAdapter(Context mContext, List<PriceBean> mAllDatas) {
        this.mAllDatas = mAllDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_travel_detail_price, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.travelName.setText(mAllDatas.get(position).getTravel_name());
        holder.travelPrice.setText(mAllDatas.get(position).getTravel_price());
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
        @BindView(R.id.tv_travel_name)
        TextView travelName;
        @BindView(R.id.tv_travel_price)
        TextView travelPrice;
        @BindView(R.id.view_price_divider)
        View divider;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
