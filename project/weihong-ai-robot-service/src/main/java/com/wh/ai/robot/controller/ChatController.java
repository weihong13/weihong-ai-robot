package com.wh.ai.robot.controller;

import com.wh.ai.robot.aspect.ApiOperationLog;
import com.wh.ai.robot.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: GHW
 * @Date: 2025/10/22 14:55
 * @Version: v1.0.0
 * @Description: 对话
 **/
@RestController
@RequestMapping("/chat")
@Slf4j
public class ChatController {

    @PostMapping("/new")
    @ApiOperationLog(description = "新建对话")
    public Response<?> newChat() {
        log.trace("这是一个 TRACE 级别日志");
        log.debug("这是一个 DEBUG 级别日志");
        log.info("这是一个 INFO 级别日志");
        log.warn("这是一个 WARN 级别日志");
        log.error("这是一个 ERROR 级别日志");

        // 模拟一个运行时错误（分母不能为 0）
        int i = 1 / 0;

        return Response.success();
    }

}

