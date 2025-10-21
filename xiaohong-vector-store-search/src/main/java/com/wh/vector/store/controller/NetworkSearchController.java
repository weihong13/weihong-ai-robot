package com.wh.vector.store.controller;

import com.wh.vector.store.model.SearchResult;
import com.wh.vector.store.servcie.SearXNGService;
import com.wh.vector.store.servcie.SearchResultContentFetcherService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


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

    @Resource
    private SearchResultContentFetcherService searchResultContentFetcherService;

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

    /**
     * 测试
     * @param message
     * @return
     */
    @GetMapping(value = "/test1")
    public List<SearchResult> generateStream1(@RequestParam(value = "message") String message) {
        // 调用 SearXNG 获取搜索结果
        List<SearchResult> searchResults = searXNGService.search(message);

        // 并发请求，获取搜索结果页面的内容
        CompletableFuture<List<SearchResult>> resultsFuture = searchResultContentFetcherService.batchFetch(searchResults, 7, TimeUnit.SECONDS);

        List<SearchResult> searchResultList = resultsFuture.join();

        // TODO 后续处理

        return searchResultList;
    }

}


