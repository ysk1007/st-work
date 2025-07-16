package com.example.openApi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.openApi.dto.ChatHistoryDto;

@Mapper
public interface ChatMapper {
	List<ChatHistoryDto> selectChatList(String userId);
	int insertChat(ChatHistoryDto chatHistoryDto);
}
