package com.example.question.common;

public enum ResponseCode {
    SUCCESS(10000,"请求成功"),
    ERROR(10001,"请求失败"),
    FAIL(10002,"计算失败"),
    PARAM_ERROR(10003,"参数错误");

    ResponseCode(int code , String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
