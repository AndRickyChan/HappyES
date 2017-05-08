package com.ricky.happyes.bean.home;

import com.ricky.happyes.bean.TravelBean;

import java.util.List;

/**
 * 首页数据信息
 * Created by Ricky on 2017-4-19.
 */

public class HomeBean {
    private String message_id;
    private String message_content;
    private String message_time;
    private List<TravelBean> hot_travel;


    public List<TravelBean> getHot_travel() {
        return hot_travel;
    }

    public void setHot_travel(List<TravelBean> hot_travel) {
        this.hot_travel = hot_travel;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public String getMessage_time() {
        return message_time;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }
}
