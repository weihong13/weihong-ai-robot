package com.wh.ai.robot.model.vo.chat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: GHW
 * @date: 2025/10/23 09:07
 * @description: 新建对话
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewChatReqVO {

    @NotBlank(message = "用户消息不能为空")
    private String message;

}


