package com.ricky.happyes.ui.setting;

import android.content.Context;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ricky.happyes.R;
import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.RxPresenter;
import com.ricky.happyes.util.DataCleanUtils;
import com.ricky.happyes.util.SPUtils;

/**
 * 设置
 * Created by Ricky on 2017-3-13.
 */

public class SettingPresenter extends RxPresenter<SettingContract.View> implements SettingContract.Presenter {

    public SettingPresenter(SettingContract.View mView) {
        super(mView);
    }

    @Override
    public void clearCache(Context mContext) {
        MaterialDialog dialog = new MaterialDialog.Builder(mContext)
                .content(mContext.getString(R.string.text_clear_cache_content))
                .positiveText(mContext.getString(R.string.text_clear_cache_sure))
                .negativeText(mContext.getString(R.string.text_clear_cache_cancel))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        try {
                            DataCleanUtils.clearAllCache(mContext);
                            mView.setCacheSize(DataCleanUtils.getTotalCacheSize(mContext));
                        } catch (Exception e) {
                            e.printStackTrace();
                            mView.showError("系统错误，请稍后重试");
                        }
                    }
                })
                .build();
        dialog.show();
    }

    @Override
    public void logout(Context mContext) {
        MaterialDialog dialog = new MaterialDialog.Builder(mContext)
                .content(mContext.getString(R.string.text_logout_content))
                .positiveText(mContext.getString(R.string.text_logout_sure))
                .negativeText(mContext.getString(R.string.text_logout_cancel))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        //清除本地保存的用户信息
                        SPUtils.clearUserData(mContext);
                        mView.logoutSuccess();
                    }
                })
                .build();
        dialog.show();
    }

    @Override
    public void changePushStatus(Context mContext, boolean isPush) {
        boolean isAcceptPush = !isPush;
        SPUtils.put(mContext, Constants.ACCEPT_PUSH_MESSAGE, isAcceptPush);
        // TODO: 2017-3-13 处理推送设置

        //更新UI显示状态
        mView.updatePushStatusUI(isAcceptPush);
    }
}
