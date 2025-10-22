package com.wh.ai.robot.advisor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;

/**
 * @Author: ghw
 * @Date: 2025/10/14 10:56
 * @Version: v1.0.0
 * @Description: 自定义日志记录 Advisor
 * CallAdvisor 和 StreamAdvisor是两种不同类型的 Advisor
 * 分别用于处理 同步调用 和 流式调用 场景。
 **/
@Slf4j
public class MyLoggerAdvisor implements CallAdvisor {

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        log.info("## 请求入参: {}", chatClientRequest);
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);
        log.info("## 请求出参: {}", chatClientResponse);
        return chatClientResponse;
    }

    @Override
    public int getOrder() {
        return 1; // order 值越小，越先执行
    }

    @Override
    public String getName() {
        // 获取类名称
        return this.getClass().getSimpleName();
    }
}

