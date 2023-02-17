package com.workspace.spaceserver.common.exception.code;

/**
 * @author hhao
 */
public interface ExceptionCode {
    /**
     * 异常状态码
     *
     * @return code
     */
    Integer getCode();

    /**
     * 异常信息
     *
     * @return msg
     */
    String getMsg();
}