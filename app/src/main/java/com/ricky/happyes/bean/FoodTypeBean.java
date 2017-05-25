package com.ricky.happyes.bean;

/**
 * 美食类型
 * Created by Ricky on 2017-5-25.
 */

public class FoodTypeBean {
    private String type_id;
    private String type_logo;
    private String type_name;
    private boolean isSelected;

    public FoodTypeBean(String type_id, String type_logo, String type_name, boolean isSelected) {
        this.type_id = type_id;
        this.type_logo = type_logo;
        this.type_name = type_name;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_logo() {
        return type_logo;
    }

    public void setType_logo(String type_logo) {
        this.type_logo = type_logo;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
