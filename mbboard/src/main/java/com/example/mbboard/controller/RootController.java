package com.example.mbboard.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mbboard.service.RootService;

@Controller
public class RootController {
	
	@Autowired RootService rootService;
	
	@GetMapping("/")
	public String index(Model model) {
		
		// 모든 전체 접속 카운트(누적)
		// 멤버 접속 카운트(누적)
		// 관리자 접속 카운트(누적)
		// 오늘 전체 접속 카운트(누적)
		// 오늘 멤버 접속 카운트(누적)
		// 오늘 관리자 접속 카운트(누적)
		Map<String, Integer> connectCountAll = rootService.getConnectCountAll();
		Map<String, Integer> connectCountToday = rootService.getConnectCountToday();
		model.addAttribute("connectCountAll",connectCountAll);
		model.addAttribute("connectCountToday",connectCountToday);
		return "index";
	}
}
