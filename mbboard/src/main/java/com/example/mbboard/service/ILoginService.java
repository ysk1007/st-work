package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Member;

public interface ILoginService{
	Member login(Member paramMember);
	
	int joinMember(Member paramMember);
	
	int updateMember(Member paramMember);
	
	List<Member> selectMemberList();
}
