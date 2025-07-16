package com.example.openApi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.openApi.dto.ChatHistoryDto;
import com.example.openApi.service.AiChatService;
import com.example.openApi.service.ChatService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {

	private AiChatService aiChatService;
	private ChatService chatService;
	
	public ChatController(AiChatService aiChatService, ChatService chatService) {
		this.aiChatService = aiChatService;
		this.chatService = chatService;
	}
	
	@GetMapping({"/","/chat"})
	public String chat(Model model, HttpSession session) {
		List<ChatHistoryDto> chatList = chatService.selectChatList(session.getId());
		
		// 채팅 내역 디버깅
//		for(ChatHistoryDto c : chatList) {
//			System.out.println(c.toString());
//		}
		
		
		model.addAttribute("chatList",chatList);
		model.addAttribute("sessionId",session.getId());
		return "chat";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
