package com.ricky.happyes.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基本工具类
 * Created by Ricky on 2017-4-11.
 */

public class CommonUtils {
    /**
     * 验证是否是手机号
     *
     * @param phone 需要验证的手机号
     * @return boolean
     */
    public static boolean isPhone(String phone) {
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile("^1[0-9]{10}$");
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }
}
