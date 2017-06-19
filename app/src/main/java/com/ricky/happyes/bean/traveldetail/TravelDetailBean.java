package com.ricky.happyes.bean.traveldetail;

import java.util.List;

/**
 * 景点详情
 * Created by Ricky on 2017-6-19.
 */

public class TravelDetailBean {
    private String travel_id;
    private String travel_name;
    private String travel_bg;
    private boolean is_collect;
    private String travel_location;
    private int travel_star;
    private int comment_count;
    private List<PriceBean> price_list;
    private List<AdviceBean> advice_list;

    public String getTravel_id() {
        return travel_id;
    }

    public void setTravel_id(String travel_id) {
        this.travel_id = travel_id;
    }

    public String getTravel_name() {
        return travel_name;
    }

    public void setTravel_name(String travel_name) {
        this.travel_name = travel_name;
    }

    public String getTravel_bg() {
        return travel_bg;
    }

    public void setTravel_bg(String travel_bg) {
        this.travel_bg = travel_bg;
    }

    public boolean is_collect() {
        return is_collect;
    }

    public void setIs_collect(boolean is_collect) {
        this.is_collect = is_collect;
    }

    public String getTravel_location() {
        return travel_location;
    }

    public void setTravel_location(String travel_location) {
        this.travel_location = travel_location;
    }

    public int getTravel_star() {
        return travel_star;
    }

    public void setTravel_star(int travel_star) {
        this.travel_star = travel_star;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public List<PriceBean> getPrice_list() {
        return price_list;
    }

    public void setPrice_list(List<PriceBean> price_list) {
        this.price_list = price_list;
    }

    public List<AdviceBean> getAdvice_list() {
        return advice_list;
    }

    public void setAdvice_list(List<AdviceBean> advice_list) {
        this.advice_list = advice_list;
    }
}
