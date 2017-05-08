package com.ricky.happyes.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ricky.happyes.R;

/**
 * 自定义错误处理界面
 * Created by Ricky on 2017-3-14.
 */

public class CustomErrorView extends RelativeLayout implements View.OnClickListener {

    private static final String MESSAGE_ERROR_EMPTY = "暂时没有数据";//内容为空
    private static final String MESSAGE_ERROR_PARSE = "数据解析错误";//解析错误
    private static final String MESSAGE_ERROR_NO_NET = "网络异常,点击重试";//网络异常

    private static final int IMAGE_ERROR_EMPTY = R.drawable.ic_load_empty;//为空
    private static final int IMAGE_ERROR_PARSE = R.drawable.ic_load_error;//数据异常
    private static final int IMAGE_ERROR_NO_NET = R.drawable.ic_network_error;//网络异常

    public static final int ERROR_TYPE_EMPTY = 2004;//数据为空
    public static final int ERROR_TYPE_ERROR = 2002;//服务器等错误
    public static final int ERROR_TYPE_NET_ERROR = 2001;//网络异常

    private LinearLayout mErrorContainer;
    private ImageView mErrorImage;
    private TextView mErrorMessage;

    private OnReloadListener onReloadListener;

    public CustomErrorView(Context context) {
        super(context);
        init(context);
    }

    public CustomErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context mContext) {
        inflate(mContext, R.layout.layout_custom_error_view, this);
        mErrorContainer = (LinearLayout) findViewById(R.id.linear_error_container);
        mErrorImage = (ImageView) findViewById(R.id.iv_error_image);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);
    }

    public void setErrorType(int type) {
        switch (type) {
            case ERROR_TYPE_EMPTY:
                mErrorImage.setImageResource(IMAGE_ERROR_EMPTY);
                mErrorMessage.setText(MESSAGE_ERROR_EMPTY);
                mErrorContainer.setOnClickListener(null);
                break;
            case ERROR_TYPE_ERROR:
                mErrorImage.setImageResource(IMAGE_ERROR_PARSE);
                mErrorMessage.setText(MESSAGE_ERROR_PARSE);
                mErrorContainer.setOnClickListener(null);
                break;
            case ERROR_TYPE_NET_ERROR:
                mErrorImage.setImageResource(IMAGE_ERROR_NO_NET);
                mErrorMessage.setText(MESSAGE_ERROR_NO_NET);
                mErrorContainer.setOnClickListener(this);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if (onReloadListener != null) {
            onReloadListener.onReload();
        }
    }

    public interface OnReloadListener {
        void onReload();
    }

    public void setOnReloadListener(OnReloadListener callback) {
        this.onReloadListener = callback;
    }
}
