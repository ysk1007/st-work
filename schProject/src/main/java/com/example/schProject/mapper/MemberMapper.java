package com.example.schProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.schProject.dto.Member;

@Mapper
public interface MemberMapper {
	List<Member> selectMeberList();
	
	Member selectMember(Member member);
	
	Member selectPwHistory(Member member);
	
	Member login(Member member);
	
	int updateLoginDate(Member member);
	
	int updateMemberActive();
	
	List<Member> selectDormancyMemberList();
	
	int updateMember(Member member);
	
	int insertPwHistory(Member member);
	
	int deletePwHistory();
}
