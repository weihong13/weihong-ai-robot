package com.wh.ai.robot.service;

import com.wh.ai.robot.model.vo.chat.FindChatHistoryMessagePageListReqVO;
import com.wh.ai.robot.model.vo.chat.FindChatHistoryMessagePageListRspVO;
import com.wh.ai.robot.model.vo.chat.NewChatReqVO;
import com.wh.ai.robot.model.vo.chat.NewChatRspVO;
import com.wh.ai.robot.utils.PageResponse;
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

    /**
     * 查询历史消息
     * @param findChatHistoryMessagePageListReqVO
     * @return
     */
    PageResponse<FindChatHistoryMessagePageListRspVO> findChatHistoryMessagePageList(FindChatHistoryMessagePageListReqVO findChatHistoryMessagePageListReqVO);
}


