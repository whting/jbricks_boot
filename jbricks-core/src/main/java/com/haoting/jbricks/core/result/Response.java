package com.haoting.jbricks.core.result;

import java.io.Serializable;

public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int               code;
    private String            msg;
    private T                 data;

    public Response(){

    }

    /**
     * 通用成功
     */
    public static <T> Response<T> success(T data) {
        Response<T> response = new Response();
        response.data = data;
        response.code = StatusCode.SUCCESS.getStatus();
        response.msg = StatusCode.SUCCESS.getMsg();
        return response;
    }

    /**
     * 通用未知异常
     */
    public static <T> Response<T> unKnowError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.UNKNOW_ERROR.getStatus();
        response.msg = message == null ? StatusCode.UNKNOW_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用业务异常
     */
    public static <T> Response<T> bussinessError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.BUSSINESS_ERROR.getStatus();
        response.msg = message == null ? StatusCode.BUSSINESS_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用系统异常
     */
    public static <T> Response<T> systemError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.SYSTEM_ERROR.getStatus();
        response.msg = message == null ? StatusCode.SYSTEM_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用数据库异常
     */
    public static <T> Response<T> databaseError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.DATABASE_ERROR.getStatus();
        response.msg = message == null ? StatusCode.DATABASE_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用参数不正确异常
     */
    public static <T> Response<T> paramError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.PARAM_ERROR.getStatus();
        response.msg = message == null ? StatusCode.PARAM_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用解密异常
     */
    public static <T> Response<T> encryptError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.ENCRYPT_ERROR.getStatus();
        response.msg = message == null ? StatusCode.ENCRYPT_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用缓存异常
     */
    public static <T> Response<T> cacheError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.CACHE_ERROR.getStatus();
        response.msg = message == null ? StatusCode.CACHE_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用未授权异常
     */
    public static <T> Response<T> unauthorizedError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.UNAUTHORIZED_ERROR.getStatus();
        response.msg = message == null ? StatusCode.UNAUTHORIZED_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用请求不存在
     */
    public static <T> Response<T> NotFoundError(String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = StatusCode.NOT_FOUND_ERROR.getStatus();
        response.msg = message == null ? StatusCode.NOT_FOUND_ERROR.getMsg() : message;
        return response;
    }

    /**
     * 通用失败异常
     */
    public static <T> Response<T> error(EnumStatus status, String message) {
        Response<T> response = new Response();
        response.data = null;
        response.code = status.getStatus();
        response.msg = message == null ? status.getMsg() : message;
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public boolean isSuccess() {
        return code > 0;
    }

}
