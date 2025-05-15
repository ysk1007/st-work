package com.example.mbboard.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbboard.dto.Member;
import com.example.mbboard.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberRest {
	
@Autowired LoginService loginService;
	
	@GetMapping("/isId/{id}")
	public boolean isId(@PathVariable String id) {
		Member member = loginService.selectMemberId(id);
		if(member != null) {
			return true;
		}
		return false;
	}
	
	@PostMapping("/equalPw")
	public boolean equalPw(@RequestBody Member paramMember) {
	    Member member = loginService.selectMember(paramMember);
	    if(member != null) {	// MemberRest : 멤버 있음
	    	return true;
	    }
	    return false;	// MemberRest : 멤버 없음
	}
	
	@PostMapping("/member/updateRole")
	public boolean updateRole(@RequestBody Member paramMember) {
	    int row = loginService.updateMember(paramMember);
	    if(row != 1) {		// 업데이트 이상
	    	return false;
	    }
	    return true;		// 업데이트 성공
	}
}
