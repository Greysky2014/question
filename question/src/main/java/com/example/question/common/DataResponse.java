package com.example.question.common;

public class DataResponse<T> extends Response {

    public DataResponse(T data) {
        this.data = data;
    }

    public DataResponse(ResponseCode responseCode , T data) {
        super ( responseCode );
        this.data = data;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
