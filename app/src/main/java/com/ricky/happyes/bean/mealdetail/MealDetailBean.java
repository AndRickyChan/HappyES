package com.ricky.happyes.bean.mealdetail;

import java.util.List;

/**
 * 套餐详情
 * Created by Ricky on 2017-6-1.
 */

public class MealDetailBean {
    private String meal_id;
    private String meal_bg;
    private String meal_name;
    private String shop_phone;
    private float meal_price;
    private String meal_work_date;//有效期
    private String meal_use_day;//使用时间
    private List<MealRuleBean> ruleList;

    public String getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(String meal_id) {
        this.meal_id = meal_id;
    }

    public String getMeal_bg() {
        return meal_bg;
    }

    public void setMeal_bg(String meal_bg) {
        this.meal_bg = meal_bg;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public String getShop_phone() {
        return shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        this.shop_phone = shop_phone;
    }

    public float getMeal_price() {
        return meal_price;
    }

    public void setMeal_price(float meal_price) {
        this.meal_price = meal_price;
    }

    public String getMeal_work_date() {
        return meal_work_date;
    }

    public void setMeal_work_date(String meal_work_date) {
        this.meal_work_date = meal_work_date;
    }

    public String getMeal_use_day() {
        return meal_use_day;
    }

    public void setMeal_use_day(String meal_use_day) {
        this.meal_use_day = meal_use_day;
    }

    public List<MealRuleBean> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<MealRuleBean> ruleList) {
        this.ruleList = ruleList;
    }
}
