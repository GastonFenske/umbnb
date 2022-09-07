package com.um.util;

public class ResponseUtil {
    
    private String message;

    private boolean success;

    private Integer code;

    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseUtil(String message, boolean success, Integer code, Object data) {
        this.setMessage(message);
        this.setSuccess(success);
        this.setCode(code);
        this.setData(data);
    }

}