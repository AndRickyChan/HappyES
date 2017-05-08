package com.ricky.happyes.ui.code;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.ui.register.RegisterActivity;
import com.ricky.happyes.ui.resetpass.ResetPassActivity;
import com.ricky.happyes.util.ToastUtils;
import com.ricky.happyes.widgets.CountDownButton;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * 获取验证码
 * Created by Ricky on 2017-3-18.
 */

public class CodeActivity extends BaseActivity<CodePresenter> implements CodeContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_input_phone)
    TextInputEditText phone;
    @BindView(R.id.et_input_code)
    TextInputEditText code;
    @BindView(R.id.cdb_get_code)
    CountDownButton mBtnCode;
    @BindView(R.id.btn_submit_code)
    Button mBtnNext;

    public static final String WHERE_FROM = "where_from";//从哪个界面来
    public static final int FROM_REGISTER = 0;//从注册界面来
    public static final int FROM_FORGETPASS = 1;//从忘记密码界面来
    public static final String CODE_PHONE_NEXT = "code_phone_to_next";//向下个界面传递的电话号码

    private static final int REQUEST_REGISTER = 1001;//注册请求码
    private static final int REQUEST_FORGET_PASS = 1002;//忘记密码请求码

    private int whereFrom = 0;//默认为从注册界面来
    private Subscription subscription;

    @Override
    public CodePresenter getPresenter() {
        return new CodePresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_code;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);

        //初始化从哪个界面跳转过来的
        whereFrom = getIntent().getIntExtra(WHERE_FROM, 0);

        Observable<CharSequence> mObservablePhone = RxTextView.textChanges(phone);
        Observable<CharSequence> mObservableCode = RxTextView.textChanges(code);
        subscription = Observable.combineLatest(mObservablePhone, mObservableCode, new Func2<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean call(CharSequence phone, CharSequence code) {
                return mPresenter.isPhoneValid(phone.toString()) && mPresenter.isCodeValid(code.toString());
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                RxView.enabled(mBtnNext).call(aBoolean);
            }
        });
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    public void onVerifySuccess() {
        Intent mIntent = new Intent();
        mIntent.putExtra(CODE_PHONE_NEXT, phone.getText().toString());
        switch (whereFrom) {
            case FROM_REGISTER://从注册过来
                mIntent.setClass(this, RegisterActivity.class);
                startActivityForResult(mIntent, REQUEST_REGISTER);
                break;
            case FROM_FORGETPASS://从忘记密码过来
                mIntent.setClass(this, ResetPassActivity.class);
                startActivityForResult(mIntent, REQUEST_FORGET_PASS);
                break;
        }
        finish();
    }

    /**
     * 获取验证码成功
     */
    @Override
    public void onGetCodeSuccess() {
        //设置可以倒计时
        mBtnCode.setCountDownEnable(true);
        //开始倒计时
        mBtnCode.startCountDown();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBtnCode.removeCountDownTimer();
        if (subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            finish();
        }
    }

    /**
     * 获取验证码
     */
    @OnClick(R.id.cdb_get_code)
    public void getCode() {
        String phoneStr = phone.getText().toString();
        mPresenter.getCode(this, phoneStr, whereFrom);
    }

    /**
     * 下一步（校验验证码）
     */
    @OnClick(R.id.btn_submit_code)
    public void verifyCode() {
        String phoneStr = phone.getText().toString();
        String codeStr = code.getText().toString();
        mPresenter.verifyCode(this, phoneStr, whereFrom, codeStr);
    }
}
