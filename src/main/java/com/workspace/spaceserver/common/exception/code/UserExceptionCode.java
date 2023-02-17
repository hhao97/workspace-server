package com.workspace.spaceserver.common.exception.code;


/**
 * @author hhao
 * @since 2022/6/14
 */
public enum UserExceptionCode implements ExceptionCode {
    /**
     * 用户异常
     */
    USER_EXIST(10001, "用户已存在"),
    ACCOUNT_ERROR(10002, "账号格式错误"),
    USER_NOT_EXIST(10003, "用户不存在"),
    LOGIN_ERROR(10004, "账号或密码不正确"),
    TOKEN_NOT_EXIST(10005, "登录异常"),

    USER_INIT_ERROR(10006, "初始化失败，请联系开发者");


    private final Integer code;
    private final String msg;

    UserExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}