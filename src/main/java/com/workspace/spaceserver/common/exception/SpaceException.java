package com.workspace.spaceserver.common.exception;

import com.workspace.spaceserver.common.exception.code.ExceptionCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 业务异常
 *
 * @author ruoyi
 */
@NoArgsConstructor
public final class SpaceException extends RuntimeException {

    @Setter
    @Getter
    private ExceptionCode exceptionCode;

    public SpaceException(ExceptionCode exceptionCode) {
        super(exceptionCode.getCode() + "-" + exceptionCode.getMsg());
        this.exceptionCode = exceptionCode;
    }

    public Integer getCode() {
        return exceptionCode.getCode();
    }

    public String getMsg() {
        return exceptionCode.getMsg();
    }
}
