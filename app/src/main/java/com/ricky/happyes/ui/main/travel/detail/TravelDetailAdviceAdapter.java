package com.ricky.happyes.ui.main.travel.detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.traveldetail.AdviceBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 入园参考适配器
 * Created by Ricky on 2017-6-19.
 */

public class TravelDetailAdviceAdapter extends RecyclerView.Adapter<TravelDetailAdviceAdapter.ViewHolder> {

    private List<AdviceBean> mAllDatas;
    private LayoutInflater mLayoutInflater;

    public TravelDetailAdviceAdapter(Context mContext, List<AdviceBean> mAllDatas) {
        this.mAllDatas = mAllDatas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_travel_detail_advice, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AdviceBean bean = mAllDatas.get(position);
        holder.mAdviceName.setText(bean.getAdvice_title());
        holder.mAdviceContent.setText(bean.getAdvice_content());
    }

    @Override
    public int getItemCount() {
        return mAllDatas == null ? 0 : mAllDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_travel_advice_name)
        TextView mAdviceName;
        @BindView(R.id.tv_travel_advice_content)
        TextView mAdviceContent;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
