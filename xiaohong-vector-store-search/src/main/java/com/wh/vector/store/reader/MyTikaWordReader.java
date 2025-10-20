package com.wh.vector.store.reader;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: GHW
 * @Date: 2025/10/20 09:39
 * @Version: v1.0.0
 * @Description: Word 文件读取
 **/
@Component
public class MyTikaWordReader {

    @Value("classpath:/document/中华人民共和国民法典_20200528.docx")
    private Resource resource;

    public List<Document> loadWord() {
        // 新建 TikaDocumentReader 阅读器
        TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(resource);
        // 读取并转换为 Document 文档集合
        List<Document> documents = tikaDocumentReader.get();

        // 文档分块
        TokenTextSplitter splitter = new TokenTextSplitter(); // 不设置任何构造参数，表示使用默认设置
        return splitter.apply(documents);
    }
}


