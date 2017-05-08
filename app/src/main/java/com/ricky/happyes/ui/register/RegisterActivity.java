package com.ricky.happyes.ui.register;

import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.ui.code.CodeActivity;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;

import static rx.Observable.combineLatest;

/**
 * 注册
 * Created by Ricky on 2017-4-11.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_set_nickname)
    EditText mNickName;
    @BindView(R.id.et_set_password)
    EditText mPassword;
    @BindView(R.id.btn_register_now)
    Button mBtnRegister;

    private String userPhone = "";//电话号码
    private Subscription subscription;

    @Override
    public RegisterPresenter getPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);

        userPhone = getIntent().getStringExtra(CodeActivity.CODE_PHONE_NEXT);

        //联动解决注册按钮的使用状态
        Observable<CharSequence> mObservableNickname = RxTextView.textChanges(mNickName);
        Observable<CharSequence> mObservablePassword = RxTextView.textChanges(mPassword);
        subscription = Observable.combineLatest(mObservableNickname, mObservablePassword, new Func2<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean call(CharSequence nickname, CharSequence password) {
                return mPresenter.isNicknameValid(nickname.toString()) && mPresenter.isPassValid(password.toString());
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                RxView.enabled(mBtnRegister).call(aBoolean);
            }
        });
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    public void onRegisterSuccess() {
        setResult(RESULT_OK);
        finish();
    }

    /**
     * 注册点击事件
     */
    @OnClick(R.id.btn_register_now)
    public void registerNow() {
        String nickname = mNickName.getText().toString();
        String password = mPassword.getText().toString();
        mPresenter.register(this, userPhone, nickname, password);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
