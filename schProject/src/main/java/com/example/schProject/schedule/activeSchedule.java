package com.example.schProject.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.schProject.dto.Member;
import com.example.schProject.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class activeSchedule {
	
	@Autowired JavaMailSender javaMailSender;
	@Autowired MemberService memberService;
	
	// 매월25일 23시 59분 0초에 마지막 접속 1년이 지난 멤버 휴먼계정처리(member.actiive : 'OFF') 후 메일발송
	
	@Scheduled(cron = "0 59 23 25 * *")
	//@Scheduled(cron = "* * * * * *")
	public void updateActive() {		
		// 휴면 리스트만 뽑아옴
		List<Member> dormancyList = memberService.selectDormancyMemberList();
		// 1년 미접속자가 있을때
		if(dormancyList != null) {
			// 이메일 보내야 함
			for(Member m : dormancyList) {
				log.info("휴면 계정 처리 시작");
				// 메일로 변경된 비밀번호를 보낸다
				SimpleMailMessage msg = new SimpleMailMessage();
				msg.setFrom("admin@localhost.com");
				msg.setTo(m.getEmail());
				msg.setSubject("1년 장기 미접속하여 휴면상태로 계정을 변경 합니다.");
				msg.setText("로그인 하여 휴면 상태를 해제 할 수 있습니다.");
				
				javaMailSender.send(msg);
			}
		}
		
		// 모든 1년 미접속자 휴면 처리하기
		memberService.updateMemberActive();
	}
	
	@Scheduled(cron="0 0 0 1 * *")
	//@Scheduled(cron="* * * * * *")
	public void delteHistory() {
		log.info("비밀번호 이력 갱신 합니다.");
		// 비밀번호 변경 이력 최신 5개 제외하고 모두 삭제하기
		memberService.deletePwHistory();
	}
}
