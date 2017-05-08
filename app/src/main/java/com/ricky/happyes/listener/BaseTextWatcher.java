package com.ricky.happyes.listener;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * TextWatcher基类
 * Created by Ricky on 2017-3-13.
 */

public abstract class BaseTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public abstract void afterTextChanged(Editable s);
}
