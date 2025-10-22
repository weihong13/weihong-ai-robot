package com.wh.ai.robot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: GHW
 * @Date: 2025/10/22 14:15
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Configuration
@MapperScan("com.wh.ai.robot.domain.mapper")
public class MybatisPlusConfig {
}