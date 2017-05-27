package com.ricky.happyes.ui.main.food.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.ShopCommentBean;
import com.ricky.happyes.util.ImageUtils;
import com.ricky.happyes.widgets.CircleImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 用户评价适配器
 * Created by Ricky on 2017-5-27.
 */

public class ShopCommentAdapter extends RecyclerView.Adapter<ShopCommentAdapter.ViewHolder> {

    private Context mContext;
    private List<ShopCommentBean> list;
    private LayoutInflater mLayoutInflater;

    public ShopCommentAdapter(Context mContext, List<ShopCommentBean> list) {
        this.mContext = mContext;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_shop_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShopCommentBean bean = list.get(position);
        ImageUtils.getInstance().loadPortraitHeader(mContext, bean.getUser_header(), holder.userHeader);
        holder.userName.setText(bean.getUser_name());
        holder.commentStar.setText(bean.getStar_count() + "星");
        holder.commentTime.setText(bean.getComment_time());
        holder.commentContent.setText(bean.getComment());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.circle_user_header)
        CircleImageView userHeader;
        @BindView(R.id.tv_user_name)
        TextView userName;
        @BindView(R.id.tv_user_star)
        TextView commentStar;
        @BindView(R.id.tv_comment_time)
        TextView commentTime;
        @BindView(R.id.tv_shop_comment)
        TextView commentContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
