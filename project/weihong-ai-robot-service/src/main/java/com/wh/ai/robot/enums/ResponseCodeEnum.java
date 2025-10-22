package com.wh.ai.robot.enums;

import com.wh.ai.robot.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: GHW
 * @url: www.weihong.com
 * @date: 2025-10-22 14:29
 * @description: 响应异常码
 **/
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("10001", "参数错误"),


    // ----------- 业务异常状态码 -----------
    // TODO 待填充
    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

}

