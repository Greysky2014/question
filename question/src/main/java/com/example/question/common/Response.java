package com.example.question.common;

public class Response {

    private int code;
    private String description;


    public Response() {
    }

    public Response(ResponseCode responseCode) {
        this.code = responseCode.getCode ();
        this.description = responseCode.getDescription ();
    }

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
