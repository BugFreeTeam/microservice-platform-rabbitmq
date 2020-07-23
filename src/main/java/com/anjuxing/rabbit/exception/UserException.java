package com.anjuxing.rabbit.exception;

public class UserException extends RuntimeException {
    private String code;
    private String msg;

    public UserException(UserExceptionCode userException){
        super(userException.getMsg());
        this.code = userException.getCode();
    }

    public UserException(String code,String msg){
        super(msg);
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
