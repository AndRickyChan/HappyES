package com.ricky.happyes.bean.shopdetail;

import java.util.List;

/**
 * 店铺详情
 * Created by Ricky on 2017-5-31.
 */

public class ShopDetailBean {
    private String shop_id;
    private String shop_name;
    private String shop_bg_logo;
    private int shop_star;
    private boolean isCollection;
    private float shop_average_price;
    private String shop_address;
    private String shop_phone;
    private List<MealBean> mealList;
    private List<AdviceMealBean> adviceMealList;
    private List<ShopCommentBean> commentBeanList;

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public String getShop_bg_logo() {
        return shop_bg_logo;
    }

    public void setShop_bg_logo(String shop_bg_logo) {
        this.shop_bg_logo = shop_bg_logo;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public int getShop_star() {
        return shop_star;
    }

    public void setShop_star(int shop_star) {
        this.shop_star = shop_star;
    }

    public float getShop_average_price() {
        return shop_average_price;
    }

    public void setShop_average_price(float shop_average_price) {
        this.shop_average_price = shop_average_price;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_phone() {
        return shop_phone;
    }

    public void setShop_phone(String shop_phone) {
        this.shop_phone = shop_phone;
    }

    public List<MealBean> getMealList() {
        return mealList;
    }

    public void setMealList(List<MealBean> mealList) {
        this.mealList = mealList;
    }

    public List<AdviceMealBean> getAdviceMealList() {
        return adviceMealList;
    }

    public void setAdviceMealList(List<AdviceMealBean> adviceMealList) {
        this.adviceMealList = adviceMealList;
    }

    public List<ShopCommentBean> getCommentBeanList() {
        return commentBeanList;
    }

    public void setCommentBeanList(List<ShopCommentBean> commentBeanList) {
        this.commentBeanList = commentBeanList;
    }
}
