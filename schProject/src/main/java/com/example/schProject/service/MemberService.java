package com.example.schProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schProject.dto.Member;
import com.example.schProject.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService implements IMemberService {
	@Autowired MemberMapper memberMapper;
	
	@Override
	public List<Member> selectMemberList() {
		return memberMapper.selectMeberList();
	}
	
	@Override
	public Member selectMember(Member member) {
		return memberMapper.selectMember(member);
	}
	
	@Override
	public Member login(Member member) {
		return memberMapper.login(member);
	}
	
	@Override
	public int updateLoginDate(Member member) {
		return memberMapper.updateLoginDate(member);
	}
	
	@Override
	public int updateMemberActive() {
		return memberMapper.updateMemberActive();
	}
	
	@Override
	public List<Member> selectDormancyMemberList() {
		return memberMapper.selectDormancyMemberList();
	}
	
	@Override
	public int updateMember(Member member) {
		return memberMapper.updateMember(member);
	}
	
	@Override
	public int insertPwHistory(Member member) {
		return memberMapper.insertPwHistory(member);
	}
	
	@Override
	public Member selectPwHistory(Member member) {
		return memberMapper.selectPwHistory(member);
	}
	
	@Override
	public int deletePwHistory() {
		return memberMapper.deletePwHistory();
	}
}
