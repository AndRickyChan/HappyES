package com.ricky.happyes.bean;

import java.util.List;

/**
 * 旅行
 * Created by Ricky on 2017-5-24.
 */

public class TravalListBean {
    private int code;
    private String msg;
    private List<TravelBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<TravelBean> getList() {
        return list;
    }

    public void setList(List<TravelBean> list) {
        this.list = list;
    }
}
