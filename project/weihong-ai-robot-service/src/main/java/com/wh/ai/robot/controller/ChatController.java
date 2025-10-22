package com.wh.ai.robot.controller;

import com.wh.ai.robot.aspect.ApiOperationLog;
import com.wh.ai.robot.utils.Response;
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
public class ChatController {

    @PostMapping("/new")
    @ApiOperationLog(description = "新建对话")
    public Response<?> newChat() {
        int i = 1/0;
        return Response.success();
    }

}

