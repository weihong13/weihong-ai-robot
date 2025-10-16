package com.wh.ai.robot.config;

import com.wh.ai.robot.advisor.MyLoggerAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @Author: ghw
 * @Date: 2025/10/14 10:19
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Configuration
public class ChatClientConfig {

    /**
     * 初始化 ChatClient 客户端
     * @param chatModel 依赖注入 starter 自动装配的 DeepSeekChatModel 实例，它是 ChatModel 接口的具体实现类，表示底层对接的 DeepSeek 大语言模型；
     * @return
     */
    @Bean
    public ChatClient chatClient(DeepSeekChatModel chatModel, ChatMemory chatMemory) {
        return ChatClient.builder(chatModel)
//                .defaultSystem("请你扮演一位市政院的AI机器人")
                .defaultAdvisors(new SimpleLoggerAdvisor(),
//                                    new MyLoggerAdvisor(), // 添加 Spring AI 内置的日志记录功能
                        MessageChatMemoryAdvisor.builder(chatMemory).build()
                                )
                .build();   // 使用 ChatClient 的建造者模式（Builder），将 DeepSeekChatModel 实例作为底层模型绑定到 ChatClient 客户端
    }
}
