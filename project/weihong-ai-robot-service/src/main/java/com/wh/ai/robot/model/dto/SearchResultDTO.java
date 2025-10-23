package com.wh.ai.robot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: GHW
 * @Date: 2025/10/22 11:12
 * @Version: v1.0.0
 * @Description: TODO
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultDTO {

    /**
     * 页面访问链接
     */
    private String url;

    /**
     * 相关性评分
     */
    private Double score;

    /**
     * 页面内容
     */
    private String content;
}


