package com.myuserid.pojo.response;

import com.myuserid.pojo.enums.StatusCode;

/**
 * 返回的参数封装类
 */
public class APIResponse<T> {

    private Integer statusCode;
    private T data;
    private String msg;

    public APIResponse() {
    }

    private APIResponse(StatusCode statusCode) {
        this.statusCode = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    private APIResponse(StatusCode statusCode, T data) {
        this.statusCode = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    private APIResponse(StatusCode statusCode, String msg) {
        this.statusCode = statusCode.getCode();
        this.msg = msg;
    }

    public APIResponse<T> randerSucess() {
        return new APIResponse<>(StatusCode.Success);
    }

    public APIResponse<T> randerSucess(T data) {
        return new APIResponse<>(StatusCode.Success, data);
    }

    public APIResponse<T> randerFail(StatusCode statusCode) {
        return new APIResponse<>(statusCode);
    }

    public APIResponse<T> randerFail(StatusCode errorCode, String msg) {
        return new APIResponse<>(errorCode, msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
