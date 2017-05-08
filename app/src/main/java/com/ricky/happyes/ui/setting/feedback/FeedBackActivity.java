package com.ricky.happyes.ui.setting.feedback;

import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.listener.BaseTextWatcher;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 意见反馈
 * Created by Ricky on 2017-3-13.
 */

public class FeedBackActivity extends BaseActivity<FeedBackPresenter> implements FeedBackContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_feed_back_content)
    EditText mEtContent;
    @BindView(R.id.tv_feed_back_text_count)
    TextView mTvTextCount;
    @BindView(R.id.btn_submit_feed_back)
    Button mBtnSubmit;

    @Override
    public FeedBackPresenter getPresenter() {
        return new FeedBackPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_feed_back;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);

        mEtContent.addTextChangedListener(textWatcher);
    }

    /**
     * EditText输入监听
     */
    TextWatcher textWatcher = new BaseTextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            int textCount = mEtContent.getText().length();
            if (textCount > 0) {
                mBtnSubmit.setEnabled(true);
            } else {
                mBtnSubmit.setEnabled(false);
            }
            mTvTextCount.setText(textCount + "/150");
        }
    };

    /**
     * 提交意见反馈
     */
    @OnClick(R.id.btn_submit_feed_back)
    public void submitFeedBack() {
        String content = mEtContent.getText().toString();
        mPresenter.submitFeedBack(this,content);
    }

    @Override
    public void showError(String msg) {

    }
}
