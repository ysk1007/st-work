package com.example.mbboard.controller.cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.mbboard.dto.Member;
import com.example.mbboard.service.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CookieLoginController {
	
	@Autowired LoginService loginService;
	
	@GetMapping("/cookieLogout")
	public String cookieLogout(HttpServletResponse response) {
		Cookie loginMemberId = new Cookie("loginMemberId",null);
		response.addCookie(loginMemberId);
		return "redirect:/cookieLogin";
	}
	
	@GetMapping("/cookieLogin")
	public String cookieLogin() {
		return "/cookie/cookieLogin";
	}
	
	@PostMapping("/cookieLogin")
	public String cookieLogin(HttpSession session, Model model,Member paramMember, HttpServletResponse response) {
		Member loginMember = loginService.login(paramMember);
		
		if(loginMember != null) {
			
			// 클라이언트 쿠키에도 로그인에 성공한 ID만 저장
			if(paramMember != null) {
				Cookie cookie = new Cookie("saveId",paramMember.getMemberId());
				response.addCookie(cookie);
				
				Cookie loginMemberId = new Cookie("loginMemberId",paramMember.getMemberId());
				response.addCookie(loginMemberId);
			}

			return "redirect:/cookieSuccess";
		}
		
		// 로그인 실패
		model.addAttribute("message","로그인 실패!");
		return "redirect:/cookieLogin";
	}
	
	@GetMapping("/cookieSuccess")
	public String cookieSuccess(@CookieValue(value = "loginMemberId", required = false) String loginMeberId) {
		// 로그인 전이라면 redirect:/cookieLogin
		if(loginMeberId == null || loginMeberId.equals("")) {
			return "redirect:/cookieLogin";
		}
		// 로그인 되어 있다면
		return "cookie/cookieSuccess";
	}
}
