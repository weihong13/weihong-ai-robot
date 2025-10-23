package com.wh.ai.robot.service;

import com.wh.ai.robot.model.dto.SearchResultDTO;

import java.util.List;

/**
 * @Author: GHW
 * @Date: 2025/10/20 15:53
 * @Version: v1.0.0
 * @Description: TODO
 **/
public interface SearXNGService {

    /**
     * 调用 SearXNG Api, 获取搜索结果
     *
     * @param query 搜索关键词
     * @return
     */
    List<SearchResultDTO> search(String query);
}


