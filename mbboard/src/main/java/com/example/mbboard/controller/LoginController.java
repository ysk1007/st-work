package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Member;
import com.example.mbboard.service.ILoginService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired ILoginService loginService;

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	// 초기화
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(HttpSession session) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if(loginMember != null) {
			return "/member/memberHome";
		}
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, Model model,Member paramMember) {
		Member loginMember = loginService.login(paramMember);
		
		if(loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			return "/member/memberHome";
		}
		
		// 로그인 실패
		model.addAttribute("message","로그인 실패!");
		return "/login";
	}

	@GetMapping("/member/info")	// 세션안에 상세정보를 보여주는 요청 -> 로그인 된 상태에서 요청 가능 -> 필터1
	public String info(HttpSession session) {
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		return "/member/info";
	}
	
	@GetMapping("/admin/adminHome")	// 관리자 페이지 요청 -> 로그인 된 상태이고 role이 'ADMIN' 요청 가능 -> 필터2
	public String adminHome(Model model) {
		List<Member> memberList = loginService.selectMemberList();
		model.addAttribute("memberList", memberList);
		return "/admin/adminHome";
	}
	
	// 회원 가입 페이지
	@GetMapping("/joinMember")
	public String joinMember() {
		return "joinMember";
	}
	
	// 회원 가입 기능
	@PostMapping("/joinMember")
	public String joinMember(Member member) {
		member.setMemberRole("MEMBER");
		int row = loginService.joinMember(member);
		if(row != 1) {
			throw new RuntimeException();
		}
		return "redirect:/login";
	}
	
	// 비밀번호 수정 페이지
	@GetMapping("/member/updatePw")
	public String updatePw() {
		return "/member/updatePw";
	}
	
	// 비밀번호 수정 기능
	@PostMapping("/member/updatePw")
	public String updatePw(Member member, @RequestParam (value="newPw") String newPw) {
		member.setMemberPw(newPw);
		log.info("LoginController : " + newPw);
		int row = loginService.updateMember(member);
		if(row != 1) {
			throw new RuntimeException();
		}
		
		return "redirect:/logout";
	}
	
	@GetMapping("/member/memberHome")
	public String memberHome() {
		return "/member/memberHome";
	}
}
