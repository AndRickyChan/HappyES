package com.ricky.happyes.bean.shopdetail;

/**
 * 套餐bean
 * Created by Ricky on 2017-5-27.
 */

public class MealBean {
    private String meal_id;
    private String meal_logo;
    private String meal_name;
    private String meal_day;
    private boolean need_predate;
    private float meal_price;

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getMeal_logo() {
        return meal_logo;
    }

    public void setMeal_logo(String meal_logo) {
        this.meal_logo = meal_logo;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public String getMeal_day() {
        return meal_day;
    }

    public void setMeal_day(String meal_day) {
        this.meal_day = meal_day;
    }

    public boolean isNeed_predate() {
        return need_predate;
    }

    public void setNeed_predate(boolean need_predate) {
        this.need_predate = need_predate;
    }

    public float getMeal_price() {
        return meal_price;
    }

    public void setMeal_price(float meal_price) {
        this.meal_price = meal_price;
    }
}
