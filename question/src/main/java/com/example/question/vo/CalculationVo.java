package com.example.question.vo;

import java.util.ArrayList;

/**
 * @project: question
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-09 08:07
 * @modify:
 * @version: v1.0
 **/
public class CalculationVo {

    //表达式
    private String[] params;

    //是否有第一部分
    private boolean status;
    //表达式第一部分
    private String[] firstParam;
    //参数
    private String[] paramValues;

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String[] getFirstParam() {
        return firstParam;
    }

    public void setFirstParam(String[] firstParam) {
        this.firstParam = firstParam;
    }

    public String[] getParamValues() {
        return paramValues;
    }

    public void setParamValues(String[] paramValues) {
        this.paramValues = paramValues;
    }
}
