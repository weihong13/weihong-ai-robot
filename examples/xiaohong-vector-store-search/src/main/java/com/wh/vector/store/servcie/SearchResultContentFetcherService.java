package com.wh.vector.store.servcie;

import com.wh.vector.store.model.SearchResult;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author: GHW
 * @Date: 2025/10/21 10:03
 * @Version: v1.0.0
 * @Description: 页面内容提取
 **/
public interface SearchResultContentFetcherService {


    /**
     * 并发批量获取搜索结果页面的内容
     *
     * @param searchResults
     * @param timeout
     * @param unit
     * @return
     */
    CompletableFuture<List<SearchResult>> batchFetch(List<SearchResult> searchResults,
                                                     long timeout,
                                                     TimeUnit unit);
}

