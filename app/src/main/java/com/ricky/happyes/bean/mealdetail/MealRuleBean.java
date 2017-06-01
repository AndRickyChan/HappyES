package com.ricky.happyes.bean.mealdetail;

/**
 * 套餐使用说明bean
 * Created by Ricky on 2017-6-1.
 */

public class MealRuleBean {
    private String rule_id;
    private String rule_content;

    public MealRuleBean(String rule_id, String rule_content) {
        this.rule_id = rule_id;
        this.rule_content = rule_content;
    }

    public String getRule_id() {
        return rule_id;
    }

    public void setRule_id(String rule_id) {
        this.rule_id = rule_id;
    }

    public String getRule_content() {
        return rule_content;
    }

    public void setRule_content(String rule_content) {
        this.rule_content = rule_content;
    }
}
