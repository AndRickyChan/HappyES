package com.ricky.happyes.util;

import android.app.Activity;

import java.util.Stack;

/**
 * APP统一管理类
 * Created by Ricky on 2017-3-7.
 */

public class AppManager {

    private Stack<Activity> stackActivities;
    public static AppManager instance;

    private AppManager() {
        stackActivities = new Stack<>();
    }

    public static AppManager getInstance() {
        if (instance == null) {
            synchronized (AppManager.class) {
                if (instance == null) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        stackActivities.add(activity);
    }

    public void finishActivity(Activity activity) {
        stackActivities.remove(activity);
        activity.finish();
    }

    public void finishAllActivity() {
        if (stackActivities == null)
            return;
        for (int i = 0, size = stackActivities.size(); i < size; i++) {
            stackActivities.get(i).finish();
        }
        stackActivities.clear();
    }

    public void exitApp() {
        try {
            if (stackActivities != null) {
                finishAllActivity();
            }
            android.os.Process.killProcess(android.os.Process.myPid()); // 杀死自己进程
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
