package com.ricky.happyes.ui.splash;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.KeyEvent;

import com.ricky.happyes.R;
import com.ricky.happyes.app.Constants;
import com.ricky.happyes.base.SimpleActivity;
import com.ricky.happyes.ui.login.LoginActivity;
import com.ricky.happyes.ui.main.MainActivity;
import com.ricky.happyes.util.AppUtils;
import com.ricky.happyes.util.LogUtils;
import com.ricky.happyes.util.SPUtils;
import com.yanzhenjie.alertdialog.AlertDialog;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

/**
 * 引导页
 * Created by Ricky on 2017-3-9.
 */

public class SplashActivity extends SimpleActivity implements PermissionListener {

    private Context mContext;

    private static final int REQUEST_CODE_PERMISSION = 100;
    private static final int REQUEST_CODE_SETTING = 300;
    private static final int TOUR_DELAY_TIME = 2000;//延迟时间
    private boolean isFromSetting = false;//是否从设置界面过来

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initEventAndData() {
        mContext = this;
        checkPermission();
    }

    private void checkPermission() {
        if (AppUtils.checkIsUpM()) {
            //如果手机系统高于6.0
            AndPermission.with(this)
                    .requestCode(REQUEST_CODE_PERMISSION)
                    .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                    .rationale(rationaleListener)
                    .send();
        } else {
            //如果手机系统小于6.0
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    initBaseTour();
                }
            }, TOUR_DELAY_TIME);
        }
    }

    private void initBaseTour() {
        boolean isLogin = (boolean) SPUtils.get(this, Constants.IS_LOGIN, false);
        Intent mIntent = new Intent();
        if (isLogin) {
            mIntent.setClass(this, MainActivity.class);
        } else {
            mIntent.setClass(this, LoginActivity.class);
        }
        startActivity(mIntent);
        finish();
    }

    RationaleListener rationaleListener = new RationaleListener() {
        @Override
        public void showRequestPermissionRationale(int requestCode, final Rationale rationale) {
            AlertDialog.build(mContext)
                    .setTitle("权限申请")
                    .setMessage("请把权限给我吧")
                    .setPositiveButton("好，给你", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rationale.resume();
                        }
                    })
                    .setNegativeButton("我拒绝", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            rationale.cancel();
                            finish();
                        }
                    })
                    .show();
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AndPermission.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onSucceed(int requestCode, List<String> grantPermissions) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION:
                if (isFromSetting) {
                    initBaseTour();
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            initBaseTour();
                        }
                    }, TOUR_DELAY_TIME);
                }
                break;
        }
    }

    @Override
    public void onFailed(int requestCode, List<String> deniedPermissions) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION:
                LogUtils.d("permission", "获取权限失败");
                for (String s : deniedPermissions)
                    LogUtils.d("permission", s);
                break;
        }

        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {
            AndPermission.defaultSettingDialog(this, REQUEST_CODE_SETTING)
                    .setTitle("权限申请")
                    .setMessage("您已经拒绝权限，请在设置中给我们权限")
                    .setPositiveButton("去设置")
                    .setNegativeButton("我拒绝", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    })
                    .show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {//引导页面不允许返回操作
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE_SETTING:
                isFromSetting = true;
                checkPermission();
                break;
        }
    }
}
