package com.example.schProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.schProject.dto.Member;
import com.example.schProject.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {
	@Autowired MemberService memberService;
	
	@GetMapping({"/","login"})
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String login(Member member, HttpSession session) {
		Member loginMember = memberService.login(member);
		if(loginMember != null) {
			loginMember.setActive("ON");
			session.setAttribute("loginMember", loginMember);
			memberService.updateLoginDate(loginMember);
			memberService.updateMember(loginMember);
			return "redirect:/memberList";
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		List<Member> memberList = memberService.selectMemberList();
		model.addAttribute("memberList", memberList);
		return "memberList";
	}
	
	@GetMapping("/modifyPw")
	public String modifyPw() {
		return "modifyPw";
	}
	
	@PostMapping("/modifyPw")
	public String modifyPw(Model model, Member member, @RequestParam(value = "newPw") String newPw) {
		Member selectMember = memberService.selectMember(member);
		if(selectMember != null) {
			selectMember.setPw(newPw);
			int row = memberService.updateMember(selectMember);
			if(row != 1) {
				model.addAttribute("errorMsg", "수정에 실패 했습니다.");
				return "modifyPw";
			}
			
			memberService.insertPwHistory(selectMember);
			return "redirect:/logout";
		}
		model.addAttribute("errorMsg", "기존 비밀번호가 다릅니다.");
		return "modifyPw";
	}
}
