package com.ricky.happyes.bean;

import java.util.List;

/**
 * 旅行
 * Created by Ricky on 2017-5-24.
 */

public class TravalListBean {
    private int total ;
    private int page;
    private int count;
    private List<TravelBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<TravelBean> getList() {
        return list;
    }

    public void setList(List<TravelBean> list) {
        this.list = list;
    }
}
