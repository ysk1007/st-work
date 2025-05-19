package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Member;

public interface ILoginService{
	Member login(Member paramMember);
	
	int joinMember(Member paramMember);
	
	int updateMember(Member paramMember);
	
	List<Member> selectMemberList();
	
	// 랜덤 비밀번호로 강제 변경
	void updateMemberPwByAdmin(Member member);
	
	// 이메일로 받은 새로운 비밀번호로 바꾸기
	int rechangeMemberPw(Member member);
	
	Member selectMember(Member member);
}
