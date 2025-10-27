import axios from "@/axios";

// 新建对话
export function newChat(message) {
    return axios.post("/chat/new", {message})
}
// 查询历史消息分页列表
export function findChatMessagePageList(current, size, chatId) {
    return axios.post("/chat/message/list", {current, size, chatId})
}