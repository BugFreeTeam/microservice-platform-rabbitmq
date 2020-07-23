package com.anjuxing.rabbit.exception;

public enum UserExceptionCode {
    // 数据操作错误定义
    NOT_AUTH("601","该用户无此权限，请联系管理员!");

    private String code;
    private String msg;

    UserExceptionCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

}
