package com.wh.mcp.server.qq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: GHW
 * @Date: 2025/10/17 13:52
 * @Version: v1.0.0
 * @Description: RestTemplate 配置类
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000); // 连接超时时间：10秒
        factory.setReadTimeout(10000); // 读取超时时间：10秒
        return new RestTemplate(factory);
    }
}
