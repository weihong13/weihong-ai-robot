package com.wh.mcp.server.qq.tools;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: GHW
 * @Date: 2025/10/17 14:00
 * @Version: v1.0.0
 * @Description: QQ Tool 工具
 **/
@Component
@Slf4j
public class QQTool {

    @Resource
    private RestTemplate restTemplate;

    @Value("${api-key}")
    private String apiKey;

    @Tool(description = "根据 QQ 号获取 QQ 信息")
    public String getQQInfo(String qq) {
        log.info("## 获取 QQ 信息, qq: {}", qq);

        // 请求第三方接口
        String url = String.format("https://api.nsmao.net/api/qq/query?qq=%s&key=%s", qq, apiKey);
        String result = restTemplate.getForObject(url, String.class);

        log.info("## 返参: {}", result);
        return result;
    }

}


