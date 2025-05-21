package com.example.schProject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.schProject.dto.Member;
import com.example.schProject.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberRest {

	@Autowired MemberService memberService;

	@PostMapping("/pwHistoryCheck")
	public boolean pwHistoryCheck(@RequestBody Member paramMember) {
		Member member = memberService.selectPwHistory(paramMember);
		if(member == null) {
			return true;
		}
		return false;
	}
}
