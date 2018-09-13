package com.myuserid.pojo.enums;

/**
 * api StatusCode
 * Created by Administrator on 2018/7/17.
 */
public enum StatusCode {

    UnKnow(0, "未知状态"),
    Success(200, "操作成功"),
    ClientError(400, "客户端错误"),
    Unauthorized(401, "未通过验证的"),
    NotFound(404, "资源信息不存在"),
    RequestTimeout(408, "请求超时"),
    BlacklistUser(409, "已经加黑"),
    InternalServerError(500, "系统内部错误"),
    ServiceUnavailable(503, "服务暂不可用");

    private String msg;
    private Integer code;

    StatusCode(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
