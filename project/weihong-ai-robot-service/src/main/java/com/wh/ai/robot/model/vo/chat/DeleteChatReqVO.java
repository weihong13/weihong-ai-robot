package com.wh.ai.robot.model.vo.chat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: GHW
 * @date: 2025/10/23 15:17
 * @description: 删除对话
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteChatReqVO {

    @NotBlank(message = "对话 UUID 不能为空")
    private String uuid;

}


