package com.ricky.happyes.bean.home;

/**
 * 轮播
 * Created by Ricky on 2017-4-18.
 */

public class BannerBean {
    private String banner_id;
    private String banner_url;

    public BannerBean(String banner_id, String banner_url) {
        this.banner_id = banner_id;
        this.banner_url = banner_url;
    }

    public String getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(String banner_id) {
        this.banner_id = banner_id;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }
}
