package com.wh.ai.robot.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: GHW
 * @url: www.weihong.com
 * @date: 2025-10-22 14:28
 * @description: 业务异常
 **/
@Getter
@Setter
public class BizException extends RuntimeException {
    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.errorCode = baseExceptionInterface.getErrorCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}


