package com.example.schProject.service;

import java.util.List;

import com.example.schProject.dto.Member;

public interface IMemberService {
	List<Member> selectMemberList();
	
	Member selectMember(Member member);
	
	Member login(Member member);
	
	int updateLoginDate(Member member);
	
	int updateMemberActive();
	
	// 멤버 업데이트
	int updateMember(Member member);
	
	// 휴면 멤버만 뽑기
	List<Member> selectDormancyMemberList();
	
	int insertPwHistory(Member member);
	
	Member selectPwHistory(Member member);
	
	// 비밀번호 이력 삭제하기
	int deletePwHistory();
}
