package com.bnuz.common;

public enum ResultCode implements IResultCode{
    SUCCESS(200,"操作成功"),
    ERROR(400,"操作失败"),
    NOT_FOUND(404,"没有找到"),
    UPDATE_ERROR(678,"更新失败"),
    UPDATE_SUCCESS(679,"修改成功"),
    NO_DATA_FOUND(999,"没有找到相关内容"),
    LOGIN_SUCCESS(123,"登录成功"),
    LOGIN_FAILED(1232,"用户名或者密码错误"),
    VERIFY_SUCCESS(2001,"登录验证成功"),
    VERIFY_FAILED(401,"登录验证失败"),
    NOT_LOGIN(401,"用户未登录"),
    NOT_ENOUGH_PERMISSION(403,"权限不足"),
    LOGOUT_SUCCESS(2002,"注销成功"),
    USER_ACCOUNT_USE_BY_OTHERS(401,"您的账号已经被另一台机器登录，您被迫下线")
    ;
    private  Integer code;
    private  String message;

    ResultCode(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
