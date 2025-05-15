package com.example.mbboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.Member;

@Mapper
public interface LoginMapper {
	Member login(Member paramMember);
	
	// 아이디 중복 검사
	Member selectMemberId(String id);
	
	Member selectMember(Member paramMember);
	
	int joinMember(Member paramMember);
	
	List<Member> selectMemberList();
	
	int updateMember(Member paramMember);
}
