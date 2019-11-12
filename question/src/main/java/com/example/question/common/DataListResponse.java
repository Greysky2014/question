package com.example.question.common;

import java.util.List;

public class DataListResponse<T> extends Response {

    public DataListResponse(List <T> data) {
        this.data = data;
    }

    public DataListResponse(ResponseCode responseCode , List <T> data) {
        super ( responseCode );
        this.data = data;
    }

    private List<T> data;

    public List <T> getData() {
        return data;
    }

    public void setData(List <T> data) {
        this.data = data;
    }
}
