package com.ricky.happyes.ui.resetpass;

import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.ricky.happyes.R;
import com.ricky.happyes.base.BaseActivity;
import com.ricky.happyes.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * 重置密码
 * Created by Ricky on 2017-4-11.
 */

public class ResetPassActivity extends BaseActivity<ResetPassPresenter> implements ResetPassContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_new_pass)
    EditText mEtNewPass;
    @BindView(R.id.et_confirm_pass)
    EditText mEtConfirmPass;
    @BindView(R.id.btn_reset_now)
    Button mBtnReset;

    private Subscription subscription;

    @Override
    public ResetPassPresenter getPresenter() {
        return new ResetPassPresenter(this);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_reset_pass;
    }

    @Override
    public void initEventAndData() {
        initToolbar(mToolbar);

        Observable<CharSequence> newPassObservable = RxTextView.textChanges(mEtNewPass);
        Observable<CharSequence> confirmPassObservable = RxTextView.textChanges(mEtConfirmPass);
        subscription = Observable.combineLatest(newPassObservable, confirmPassObservable, new Func2<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean call(CharSequence newPass, CharSequence confirmPass) {
                return mPresenter.isNewPassValidate(newPass.toString())
                        && mPresenter.isConfirmPassValidate(confirmPass.toString());
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                RxView.enabled(mBtnReset).call(aBoolean);
            }
        });
    }

    @Override
    public void showError(String msg) {
        ToastUtils.toastShort(this, msg);
    }

    @Override
    public void onResetSuccess() {
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .content(getString(R.string.dialog_reset_content))
                .positiveText(getString(R.string.dialog_reset_sure))
                .canceledOnTouchOutside(false)
                .cancelable(false)
                .onPositive((dialog1, which) -> {
                    finish();
                })
                .build();
        dialog.show();
    }

    @OnClick(R.id.btn_reset_now)
    public void resetNowClick() {
        String newPass = mEtNewPass.getText().toString().trim();
        String confirmPass = mEtConfirmPass.getText().toString().trim();
        mPresenter.resetPassword(this, newPass, confirmPass);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
