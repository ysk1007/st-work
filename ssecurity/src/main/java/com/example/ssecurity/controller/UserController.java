package com.example.ssecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ssecurity.dto.UserDto;
import com.example.ssecurity.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 수정 페이지
	@GetMapping("/modifyUser")
	public String modifyUser(Model model) {
		// 현재 세션에 로그인 된 아이디 전달
		String loginUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("loginUserName",loginUserName);
		
		return "modifyUser";
	}
	
	// 수정 기능
	@PostMapping("/modifyUserAction")
	public String modifyUserAction(UserDto userDto, @RequestParam String newPassword) {
		
		if(userService.modifyUser(userDto, newPassword)) {
			return "redirect:/logout";
		}
		return "redirect:/modifyUser";
	}
	
	// 삭제 페이지
	@GetMapping("/deleteUser")
	public String deleteUser(Model model) {
		// 현재 세션에 로그인 된 아이디 전달
		String loginUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("loginUserName",loginUserName);
		
		return "deleteUser";
	}
	
	// 삭제 기능
	@PostMapping("/deleteUserAction")
	public String deleteUserAction(UserDto userDto) {
		if(userService.deleteUser(userDto)) {	// 삭제 성공하면
			return "redirect:/logout";			// 세션 초기화 후 로그인 페이지로
		}
		
		// 삭제 실패시 다시 페이지로
		return "redirect:/deleteUser";
	}
	
	@GetMapping("/addUser")
	public String addUser() {
		return "addUser";
	}
	
	@PostMapping("/addUserAction")
	public String addUserAction(UserDto userDto) {
		userService.addUser(userDto);
		return "redirect:/login";
	}
}
