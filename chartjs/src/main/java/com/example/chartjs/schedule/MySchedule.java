package com.example.chartjs.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class MySchedule {
	/*
	 * @Scheduled(cron = "0 0 0 1 * *") public void myScheduleTest() {
	 * log.info("스케쥴러 테스트"); }
	 */
	
	/* 매월 25일 23시 59분 59초에 스케줄러 호출
	 *  ㄴ> 마지막 접속이 1년전 휴면계정으로 만드는 서비스 메서드 ON -> OFF 
	 *  ㄴ> 메일을 보내는 서비스 메서드
	 *   
	 * 매월 1일 0시0분0초 스케줄러 호출 -> 1개월 지난 로그인 이력을 삭제하는 서비스 메서드
	 * 컨트롤러 호출 -> 로그인시 이력을 입력하는 메서드*/
}
