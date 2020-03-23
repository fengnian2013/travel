package com.sun.travel.domain;

/**
 * @class: Result <br>
 * @author: sun <br>
 * @date: 2020-03-12 15:53
 */
public class Result<T> {
    private boolean success = false;
    private T data = null;
    private String msg = "";
    private String code = "500";
    private String traceId;

    public Result() {

    }

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result();
        r.setData(data);
        r.setSuccess(true);
        r.setCode("200");
        r.setMsg("success");
        return r;
    }

    public static <T> Result<T> fail(String msg) {
        Result<T> r = new Result();
        r.setSuccess(false);
        r.setCode("500");
        r.setMsg(msg);
        return r;
    }

    public static <T> Result<T> fail(String code,String msg) {
        Result<T> r = new Result();
        r.setSuccess(false);
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }


    public boolean isSuccess() {
        return this.success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }
}
