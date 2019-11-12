package com.example.question.vo;

/**
 * @project: question
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-10 08:49
 * @modify:
 * @version: v1.0
 **/
public class ExpenseVo {

    private String userId;
    private Integer money;
    private String descption;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption;
    }
}
