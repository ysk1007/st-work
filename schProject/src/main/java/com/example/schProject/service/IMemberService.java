package com.example.schProject.service;

import java.util.List;

import com.example.schProject.dto.Member;

public interface IMemberService {
	List<Member> selectMemberList();
	
	Member login(Member member);
	
	int updateLoginDate(Member member);
	
	int updateMemberActive();
	
	// 멤버 업데이트
	int updateMember(Member member);
	
	// 휴면 멤버만 뽑기
	List<Member> selectDormancyMemberList();
}
