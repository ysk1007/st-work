package com.example.ssecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		
		String loginUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("loginUserName",loginUserName);
		
		return "home";
	}
}
