package com.ricky.happyes.bean.mealdetail;

/**
 * 套餐食材内容bean
 * Created by Ricky on 2017-6-1.
 */

public class MealMenuContentBean {
    private String menu_name;
    private String menu_count;
    private float menu_price;
    private boolean isTitle;

    public MealMenuContentBean(String menu_name, String menu_count, float menu_price, boolean isTitle) {
        this.menu_name = menu_name;
        this.menu_count = menu_count;
        this.menu_price = menu_price;
        this.isTitle = isTitle;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_count() {
        return menu_count;
    }

    public void setMenu_count(String menu_count) {
        this.menu_count = menu_count;
    }

    public float getMenu_price() {
        return menu_price;
    }

    public void setMenu_price(float menu_price) {
        this.menu_price = menu_price;
    }
}
