package com.wh.ai.robot.config;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ghw
 * @Date: 2025/10/14 11:14
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Configuration
public class ChatMemoryConfig {

    /**
     * 记忆存储
     * 通过 @Resource 注解注入一个 ChatMemoryRepository 的实例。
     * 它用于存储聊天会话，当我们没有自定义外部存储时（如 Cassandra、MySQL），
     * 默认情况下，Spring AI 使用的是 InMemoryChatMemoryRepository 实现类，
     * 会将消息存储在内存中的 ConcurrentHashMap 中。
     */
    @Resource
    private ChatMemoryRepository chatMemoryRepository;

    /**
     * 初始化一个 ChatMemory 实例，并注入到 Spring 容器中
     * MessageWindowChatMemory：它是具体的 ChatMemory 实现类，使用 “滑动窗口” 策略管理聊天记录。
     * 滑动窗口策略：保留最近的 N 条消息（这里是50条，默认值20），
     * 超出数量限制时自动移除旧消息。因为在 AI 对话中，限制上下文长度，可以避免超出模型的 Token 限制。
     * @return
     */
    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder()
                .maxMessages(50) // 最大消息窗口为 50，默认值为 20
                .chatMemoryRepository(chatMemoryRepository) // 记忆存储
                .build();
    }
}

