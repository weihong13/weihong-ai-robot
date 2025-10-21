package com.wh.vector.store.controller;

import com.wh.vector.store.model.SearchResult;
import com.wh.vector.store.servcie.SearXNGService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: GHW
 * @Date: 2025/10/20 15:55
 * @Version: v1.0.0
 * @Description: 联网搜索
 **/
@RestController
@RequestMapping("/network")
public class NetworkSearchController {

    @Resource
    private SearXNGService searXNGService;

    /**
     * 测试
     * @param message
     * @return
     */
    @GetMapping(value = "/test")
    public List<SearchResult> generateStream(@RequestParam(value = "message") String message) {
        // 调用 SearXNG 获取搜索结果
        List<SearchResult> searchResults = searXNGService.search(message);

        return searchResults;
    }

}


