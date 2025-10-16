package com.wh.ai.robot.controller;

import com.wh.ai.robot.model.AIResponse;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ghw
 * @Date: 2025/10/14 14:55
 * @Version: v1.0.0
 * @Description: 对接 阿里云百炼
 **/
@RestController
@RequestMapping("/v6/ai")
public class AliyunBailianController {

    @Resource
    private OpenAiChatModel chatModel;

    // 存储聊天对话
    private Map<String, List<Message>> chatMemoryStore = new ConcurrentHashMap<>();

    /**
     * 普通对话
     * @param message
     * @param chatId  用于区分不同对话
     * @return
     */
    @GetMapping("/generate")
    public String generate(@RequestParam(value = "message", defaultValue = "你是谁？") String message,
                           @RequestParam(value = "chatId") String chatId) {

        // 根据chat获取聊天记录
        List<Message> messages = chatMemoryStore.get(chatId);

        // 如果不存在就初始化一份
        if (CollectionUtils.isEmpty(messages))
        {
            messages = new ArrayList<>();
            chatMemoryStore.put(chatId, messages);
        }
        // 添加"用户角色消息" 到聊天记录中
        messages.add(new UserMessage(message));

        // 构建 提示词
        Prompt prompt = new Prompt(messages);

        // 一次性返回结果
        String responseText = chatModel.call(prompt).getResult().getOutput().getText();

        messages.add(new AssistantMessage(responseText));

        return responseText;
    }

    /**
     * 流式对话
     * @param message
     * @return
     */
    @GetMapping(value = "/generateStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AIResponse> generateStream(@RequestParam(value = "message", defaultValue = "你是谁？") String message) {

        // 系统角色消息 设置一个系统角色的消息
        SystemMessage systemMessage = new SystemMessage("请你扮演一名市政院的AI数字人");
        // 用户角色消息 初始化一个用户角色消息
        UserMessage userMessage = new UserMessage(message);

        // 构建提示词  作为一个容器，将这些消息包装一下，扔给 AI 大模型；
        Prompt prompt = new Prompt(systemMessage, userMessage);

        // 流式输出
        return chatModel.stream(prompt)
                .mapNotNull(chatResponse -> {
                    Generation generation = chatResponse.getResult();
                    String text = generation.getOutput().getText();
                    return AIResponse.builder().v(text).build();
                });

    }

}

