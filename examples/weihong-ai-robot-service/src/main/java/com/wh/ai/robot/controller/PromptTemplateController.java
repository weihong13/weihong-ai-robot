package com.wh.ai.robot.controller;

import com.wh.ai.robot.model.AIResponse;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.template.st.StTemplateRenderer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: ghw
 * @Date: 2025/10/16 09:51
 * @Version: v1.0.0
 * @Description: 提示词模板
 **/
@RestController
@RequestMapping("/v7/ai")
public class PromptTemplateController {

    @Resource
    private OpenAiChatModel chatModel;

    @Value("classpath:/prompts/code-assistant.st")
    private org.springframework.core.io.Resource codeAssistant;

    /**
     * 智能代码生成
     * @param message
     * @param lang
     * @return
     */
    @GetMapping(value = "/generateStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AIResponse> generateStream(@RequestParam(value = "message") String message,
                                           @RequestParam(value = "lang") String lang) {
        // 提示词模板
        String template = """
                你是一位资深 {lang} 开发工程师。请严格遵循以下要求编写代码：
                1. 功能描述：{description}
                2. 代码需包含详细注释
                3. 使用业界最佳实践
                """;
        // PromptTemplate promptTemplate = new PromptTemplate(codeAssistant); 静态加载提示词模板

        PromptTemplate promptTemplate = new PromptTemplate(codeAssistant);  // 使用文件加载提示词模板

        // 填充提示词占位符，转换为 Prompt 提示词对象
        Prompt prompt = promptTemplate.create(Map.of("description", message, "lang", lang));

        // 流式输出
        return chatModel.stream(prompt)
                .mapNotNull(chatResponse -> {
                    Generation generation = chatResponse.getResult();
                    String text = generation.getOutput().getText();
                    return AIResponse.builder().v(text).build();
                });
    }


    /**
     * 智能代码生成 2
     * @param message
     * @param lang
     * @return
     */
    @GetMapping(value = "/generateStream2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AIResponse> generateStream2(@RequestParam(value = "message") String message,
                                            @RequestParam(value = "lang") String lang) {

        /*
            .renderer(StTemplateRenderer.builder().startDelimiterToken('<').endDelimiterToken('>').build())
            这行代码，通过 字符串模板渲染器 StTemplateRenderer，设置了模板变量的起始分隔符为 <，结束分隔符为 >，
            其他部分和之前差不多，除了提示词模板中的占位符，从花括号 {} 修改为了 <> 尖括号。
         */
        // 提示词模板
        PromptTemplate promptTemplate = PromptTemplate.builder()
                .renderer(StTemplateRenderer.builder().startDelimiterToken('<').endDelimiterToken('>').build()) // 自定义占位符
                .template("""
                        你是一位资深 <lang> 开发工程师。请严格遵循以下要求编写代码：
                        1. 功能描述：<description>
                        2. 代码需包含详细注释
                        3. 使用业界最佳实践
                        """)
                .build();

        // 填充提示词占位符，转换为 Prompt 提示词对象
        Prompt prompt = promptTemplate.create(Map.of("description", message, "lang", lang));

        // 流式输出
        return chatModel.stream(prompt)
                .mapNotNull(chatResponse -> {
                    Generation generation = chatResponse.getResult();
                    String text = generation.getOutput().getText();
                    return AIResponse.builder().v(text).build();
                });
    }


    /**
     * 智能代码生成 3
     * @param message
     * @param lang
     * @return
     */
    @GetMapping(value = "/generateStream3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<AIResponse> generateStream3(@RequestParam(value = "message") String message,
                                            @RequestParam(value = "lang") String lang) {

        // 系统角色提示词模板
        String systemPrompt = """
                你是一位资深 {lang} 开发工程师, 已经从业数十年，经验非常丰富。
                """;
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemPrompt);
        // 填充提示词占位符，并转换为 Message 对象
        Message systemMessage = systemPromptTemplate.createMessage(Map.of("lang", lang));

        // 用户角色提示词模板
        String userPrompt = """
                请严格遵循以下要求编写代码：
                1. 功能描述：{description}
                2. 代码需包含详细注释
                3. 使用业界最佳实践
                """;
        PromptTemplate promptTemplate = new PromptTemplate(userPrompt);
        // 填充提示词占位符，并转换为 Message 对象
        Message userMessage = promptTemplate.createMessage(Map.of("description", message));


        // 组合多角色消息，构建提示词 Prompt
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));

        // 流式输出
        return chatModel.stream(prompt)
                .mapNotNull(chatResponse -> {
                    Generation generation = chatResponse.getResult();
                    String text = generation.getOutput().getText();
                    return AIResponse.builder().v(text).build();
                });
    }


}

