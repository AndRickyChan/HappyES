package com.ricky.happyes.bean;

/**
 * 个人信息bean
 * Created by Ricky on 2017-3-18.
 */

public class UserBean {
    private String id ;
    private String userHeaderUrl ;
    private String nickName ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserHeaderUrl() {
        return userHeaderUrl;
    }

    public void setUserHeaderUrl(String userHeaderUrl) {
        this.userHeaderUrl = userHeaderUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
