package com.example.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ajax.dto.Member;
import com.example.ajax.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired MemberMapper memberMapper;
	
	@GetMapping("/joinMember")
	public String joinMember() {
		return "joinMember";
	}
	
	@Transactional
	@PostMapping("/joinMember")
	public String joinMember(Member member) {
		member.setAddress();
		int row = memberMapper.insertMember(member);
		
		// insert 행의 수가 1이 아님
		if(row != 1) {
			throw new RuntimeException();
		}
		
		return "redirect:/joinMember";
	}
}
