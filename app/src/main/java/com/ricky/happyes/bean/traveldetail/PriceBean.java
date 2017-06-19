package com.ricky.happyes.bean.traveldetail;

/**
 * 景点报价
 * Created by Ricky on 2017-6-19.
 */

public class PriceBean {
    private String price_id;
    private String travel_name;
    private String travel_price;

    public String getPrice_id() {
        return price_id;
    }

    public void setPrice_id(String price_id) {
        this.price_id = price_id;
    }

    public String getTravel_name() {
        return travel_name;
    }

    public void setTravel_name(String travel_name) {
        this.travel_name = travel_name;
    }

    public String getTravel_price() {
        return travel_price;
    }

    public void setTravel_price(String travel_price) {
        this.travel_price = travel_price;
    }
}
