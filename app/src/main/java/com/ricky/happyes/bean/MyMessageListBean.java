package com.ricky.happyes.bean;

import java.util.List;

/**
 * 我的消息
 * Created by Ricky on 2017-3-14.
 */

public class MyMessageListBean {
    private int total ;
    private int page;
    private int count;
    private List<MyMessage> list;

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

    public List<MyMessage> getList() {
        return list;
    }

    public void setList(List<MyMessage> list) {
        this.list = list;
    }

    public class MyMessage{
        private int id ;
        private String title ;
        private String content;
        private String createTime ;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
