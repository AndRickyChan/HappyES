package com.ricky.happyes.ui.main.food;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.ShopListBean;
import com.ricky.happyes.util.ImageUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 美食列表适配器
 * Created by Ricky on 2017-5-25.
 */

public class ShopContentAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<ShopListBean.ShopBean> list;
    private LayoutInflater mLayoutInflater;

    public ShopContentAdapter(Context mContext, List<ShopListBean.ShopBean> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_food_content, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        if (holder1 instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder) holder1;
            ShopListBean.ShopBean bean = list.get(position);
            ImageUtils.getInstance().loadShopLogoImage(mContext, bean.getShop_logo(), holder.shopLogo);
            holder.shopTitle.setText(bean.getShop_title());
            holder.shopPrice.setText("￥" + bean.getShop_price() + "元/人");
            holder.shopStar.setText(bean.getShop_star() + " 星");
            holder.shopAddress.setText(bean.getShop_address());
            holder.shopType.setText(bean.getShop_type());
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_shop_logo)
        ImageView shopLogo;
        @BindView(R.id.tv_shop_title)
        TextView shopTitle;
        @BindView(R.id.tv_shop_price)
        TextView shopPrice;
        @BindView(R.id.tv_shop_star)
        TextView shopStar;
        @BindView(R.id.tv_shop_address)
        TextView shopAddress;
        @BindView(R.id.tv_shop_type)
        TextView shopType;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
