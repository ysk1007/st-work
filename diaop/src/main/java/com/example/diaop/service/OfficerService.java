package com.example.diaop.service;

import org.springframework.stereotype.Component;

@Component
public class OfficerService implements PersonService{
	public void service() {
		System.out.println("공무원이 길을 안내하다");
	}
}
