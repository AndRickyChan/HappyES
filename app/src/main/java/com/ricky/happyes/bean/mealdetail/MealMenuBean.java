package com.ricky.happyes.bean.mealdetail;

import java.util.List;

/**
 * 套餐食材bean
 * Created by Ricky on 2017-6-1.
 */

public class MealMenuBean {
    private String title;
    private List<MealMenuContentBean> list;

    public MealMenuBean(String title, List<MealMenuContentBean> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MealMenuContentBean> getList() {
        return list;
    }

    public void setList(List<MealMenuContentBean> list) {
        this.list = list;
    }
}
