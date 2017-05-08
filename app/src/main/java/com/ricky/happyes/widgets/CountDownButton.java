package com.ricky.happyes.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.ricky.happyes.R;

/**
 * 自定义倒计时按钮
 * Created by Ricky on 2017-4-10.
 */

public class CountDownButton extends AppCompatButton {

    private int countDownTime;//倒计时时间(单位：秒)
    private boolean countDownEnable;//是否可以倒计时

    private static final String BUTTON_TITLE = "获取验证码";//按钮显示文字

    private CountDownTimer mCountDownTimer;//倒计时计时器


    public CountDownButton(Context context) {
        this(context, null);
    }

    public CountDownButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CountDownButton);
        countDownTime = typedArray.getInt(R.styleable.CountDownButton_customTime, 60);
        countDownEnable = typedArray.getBoolean(R.styleable.CountDownButton_customEnableDown, false);

        typedArray.recycle();

        setText(BUTTON_TITLE);

        if (mCountDownTimer == null) {
            mCountDownTimer = new CountDownTimer(countDownTime * 1000 - 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    setText((millisUntilFinished / 1000) + "秒后重新获取");
                }

                @Override
                public void onFinish() {
                    setCountDownEnable(false);
                    setEnabled(true);
                    setClickable(true);
                    setText(BUTTON_TITLE);
                }
            };
        }
    }

    /**
     * 开始倒计时
     */
    public void startCountDown() {
        if (countDownEnable) {
            setCountDownEnable(false);
            setEnabled(false);
            setClickable(false);
            mCountDownTimer.start();
        }
    }

    /**
     * 移除倒计时时间
     */
    public void removeCountDownTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        setText(BUTTON_TITLE);
        setEnabled(true);
        setClickable(true);
        setCountDownEnable(true);
    }

    public void setCountTime(int time) {
        this.countDownTime = time;
    }

    public void setCountDownEnable(boolean enable) {
        this.countDownEnable = enable;
    }
}
