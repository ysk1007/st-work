package com.example.openApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.openApi.dto.ChatHistoryDto;
import com.example.openApi.mapper.ChatMapper;

@Service
public class ChatService {

	ChatMapper chatMapper;
	
	public ChatService(ChatMapper chatMapper) {
		this.chatMapper = chatMapper;
	}
	
	public List<ChatHistoryDto> selectChatList(String userId){
		return chatMapper.selectChatList(userId);
	}
	
	public int insertChat(ChatHistoryDto chatHistoryDto) {
		return chatMapper.insertChat(chatHistoryDto);
	}
}
