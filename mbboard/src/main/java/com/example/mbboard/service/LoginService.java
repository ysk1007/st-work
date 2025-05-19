package com.example.mbboard.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Member;
import com.example.mbboard.mapper.LoginMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class LoginService implements ILoginService{
	
	@Autowired JavaMailSender javaMailSender;
	@Autowired LoginMapper loginMapper;
	
	// 이메일로 받은 새로운 비밀번호로 바꾸기
	public int rechangeMemberPw(Member member) {
		return loginMapper.rechangeMemberPw(member);
	}
	
	public void updateMemberPwByAdmin(Member member) {
		// 새로운 패스워드를 생성
		String randomPw = UUID.randomUUID().toString().replace("-","").substring(0,8);
		member.setMemberPw(randomPw);
		int row = loginMapper.updateMemberPwByAdmin(member);
		if(row == 1) {
			// 메일로 변경된 비밀번호를 보낸다
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("admin@localhost.com");
			msg.setTo(member.getEmail());
			msg.setSubject("변경된 비밀번호 입니다.");
			msg.setText("10분안에 로그인하여 수정하셔야 합니다." + randomPw);
			
			javaMailSender.send(msg);
		}
	}
	
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
