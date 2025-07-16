package com.example.openApi.dto;

import lombok.Data;

@Data
public class ChatHistoryDto {
	private int chatId;
	private String userId;
	private String userMsg;
	private String aiReply;
	private String createAt;
}
