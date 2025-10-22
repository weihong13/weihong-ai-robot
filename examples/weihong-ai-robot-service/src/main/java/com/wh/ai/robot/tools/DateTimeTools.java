package com.wh.ai.robot.tools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;

import java.time.LocalDateTime;

/**
 * @Author: GHW
 * @Date: 2025/10/17 10:04
 * @Version: v1.0.0
 * @Description: 日期 Tool
 **/
@Slf4j
public class DateTimeTools {

    @Tool(description = "获取当前日期和时间")
    String getCurrentDateTime() {
        return LocalDateTime.now().toString();
    }

}
