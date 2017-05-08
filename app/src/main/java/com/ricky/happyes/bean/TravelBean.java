package com.ricky.happyes.bean;

/**
 * 景点bean
 * Created by Ricky on 2017-4-19.
 */

public class TravelBean {
    private String travel_id;
    private String travel_logo;
    private String travel_title;
    private String travel_des;
    private int good_point;
    private int travel_price;

    public String getTravel_logo() {
        return travel_logo;
    }

    public void setTravel_logo(String travel_logo) {
        this.travel_logo = travel_logo;
    }

    public String getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(String travel_id) {
        this.travel_id = travel_id;
    }

    public String getTravel_title() {
        return travel_title;
    }

    public void setTravel_title(String travel_title) {
        this.travel_title = travel_title;
    }

    public String getTravel_des() {
        return travel_des;
    }

    public void setTravel_des(String travel_des) {
        this.travel_des = travel_des;
    }

    public int getGood_point() {
        return good_point;
    }

    public void setGood_point(int good_point) {
        this.good_point = good_point;
    }

    public int getTravel_price() {
        return travel_price;
    }

    public void setTravel_price(int travel_price) {
        this.travel_price = travel_price;
    }
}
