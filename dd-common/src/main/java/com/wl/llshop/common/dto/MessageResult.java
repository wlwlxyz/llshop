package com.wl.llshop.common.dto;

/**
 * 处理消息结果的工具
 * User: Administrator
 * Date: 2017/11/22
 * Time: 18:01
 * Version:V1.0
 */
public class MessageResult {

    //判定返回是否成功
    private boolean success;
    //存放返回的消息
    private String message;
    //存放返回的对象
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
