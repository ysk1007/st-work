package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class LoginService implements ILoginService{
	
	@Autowired LoginMapper loginMapper;
	
	public Member login(Member paramMember) {
		return loginMapper.login(paramMember);
	}

	public int joinMember(Member paramMember) {
		return loginMapper.joinMember(paramMember);
	}
	
	// 아이디 중복 검사
	public Member selectMemberId(String memberId) {
		return loginMapper.selectMemberId(memberId);
	}
	
	// 비밀번호 확인
	public Member selectMember(Member paramMember) {
		return loginMapper.selectMember(paramMember);
	}
	
	public List<Member> selectMemberList() {
		return loginMapper.selectMemberList();
	}
	
	public int updateMember(Member paramMember) {
		return loginMapper.updateMember(paramMember);
	}
}
