package com.ricky.happyes.ui.login;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.ricky.happyes.R;
import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.ui.code.CodeActivity;
import com.ricky.happyes.ui.main.MainActivity;
import com.ricky.happyes.util.SPUtils;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;


/**
 * 登录
 * Created by Ricky on 2017-3-18.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_input_phone)
    TextInputEditText phone;
    @BindView(R.id.et_input_password)
    TextInputEditText password;
    @BindView(R.id.btn_es_play_login)
    Button mBtnLogin;
    @BindView(R.id.tv_forget_password)
    TextView mForgetPass;

    private Subscription subscription;


    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initEventAndData() {
        //实现动态联动登录按钮状态
        Observable<CharSequence> mObservablePhone = RxTextView.textChanges(phone);
        Observable<CharSequence> mObservablePass = RxTextView.textChanges(password);
        subscription = Observable.combineLatest(mObservablePhone, mObservablePass, new Func2<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean call(CharSequence phone, CharSequence pass) {
                return mPresenter.isPassValid(pass.toString()) && mPresenter.isPhoneValid(phone.toString());
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                RxView.enabled(mBtnLogin).call(aBoolean);
            }
        });
    }

    @Override
    public void onLoginSuccess() {
        SPUtils.put(this, Constants.IS_LOGIN, true);
        Intent mIntent = new Intent(this, MainActivity.class);
        startActivity(mIntent);
        finish();
    }

    /**
     * 登录
     */
    @OnClick(R.id.btn_es_play_login)
    public void login() {
        String phoneStr = phone.getText().toString();
        String passwordStr = password.getText().toString();
        mPresenter.login(this, phoneStr, passwordStr);
    }

    /**
     * 忘记密码
     */
    @OnClick(R.id.tv_forget_password)
    public void forgetPass() {
        Intent mIntent = new Intent(this, CodeActivity.class);
        mIntent.putExtra(CodeActivity.WHERE_FROM, CodeActivity.FROM_FORGETPASS);
        startActivity(mIntent);
    }

    /**
     * 注册
     */
    @OnClick(R.id.tv_register)
    public void register() {
        Intent mIntent = new Intent(this, CodeActivity.class);
        mIntent.putExtra(CodeActivity.WHERE_FROM, CodeActivity.FROM_REGISTER);
        startActivity(mIntent);
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
