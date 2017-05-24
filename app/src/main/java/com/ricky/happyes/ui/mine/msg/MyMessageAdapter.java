package com.ricky.happyes.ui.mine.msg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.bean.MyMessageListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的消息item适配器
 * Created by Ricky on 2017-3-14.
 */

public class MyMessageAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<MyMessageListBean.MyMessage> messageList;
    private LayoutInflater mLayoutInflater;

    public MyMessageAdapter(Context mContext, List<MyMessageListBean.MyMessage> messageList) {
        this.mContext = mContext;
        this.messageList = messageList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_my_message, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder1, int position) {
        if (holder1 instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder) holder1;
            MyMessageListBean.MyMessage bean = messageList.get(position);
            holder.title.setText(bean.getTitle());
            holder.content.setText(bean.getContent());
            holder.createTime.setText(bean.getCreateTime());
        }
    }

    @Override
    public int getItemCount() {
        return messageList == null ? 0 : messageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_message_title)
        TextView title;
        @BindView(R.id.tv_message_content)
        TextView content;
        @BindView(R.id.tv_message_time)
        TextView createTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
