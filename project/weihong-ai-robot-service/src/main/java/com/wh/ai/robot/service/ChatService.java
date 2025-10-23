package com.wh.ai.robot.service;

import com.wh.ai.robot.model.vo.chat.NewChatReqVO;
import com.wh.ai.robot.model.vo.chat.NewChatRspVO;
import com.wh.ai.robot.utils.Response;

/**
 * @author: GHW
 * @date: 2025/10/23 09:33
 * @description: 对话
 **/
public interface ChatService {

    /**
     * 新建对话
     * @param newChatReqVO
     * @return
     */
    Response<NewChatRspVO> newChat(NewChatReqVO newChatReqVO);
}


