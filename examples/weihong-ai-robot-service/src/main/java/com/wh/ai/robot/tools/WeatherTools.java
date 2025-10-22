package com.wh.ai.robot.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;

/**
 * @Author: GHW
 * @Date: 2025/10/17 10:08
 * @Version: v1.0.0
 * @Description: 天气 Tool
 **/
@Slf4j
public class WeatherTools {

    @Tool(description = "获取当日的天气情况，时间参数需为 ISO-8601 格式")
    String getWeather(String time) {
        log.info("## time: {}", time);

        // TODO 调用第三方接口，获取当日天气情况

        return "今天天气晴朗，最低温度 18℃，最高温度 38℃";
    }
}

