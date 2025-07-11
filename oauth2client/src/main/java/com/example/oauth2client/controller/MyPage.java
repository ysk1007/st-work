package com.example.oauth2client.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.oauth2client.service.ReservationService;

@Controller
public class MyPage {
	@Autowired ReservationService reservationService;
	
	@GetMapping("/myPage")
	public String myPage(Model model) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// authentication(인증된 UserDetails DTO name)
		String loginUsername = authentication.getName();
		
		// authentication(인증된 UserDetails DTO role)
		Collection<? extends GrantedAuthority> roleList = authentication.getAuthorities();
		// 순서가 있는(forEach 가능한) 컬렉션으로 변경
		Iterator<? extends GrantedAuthority> iterator = roleList.iterator();	// 이터레이터 패턴
		
		GrantedAuthority ga = null;
		String role = "";
		if((ga=iterator.next()) != null) {
			role = ga.getAuthority();
		}
		/*
		 * 하나의 roll만 설정된 상태이기에 반복문을 사용할 필요는 없다.
		while((ga=iterator.next()) != null) {
			ga.getAuthority();
		}
		*/
		List<Map<String,Object>> list = reservationService.selectMyReservation(loginUsername);
		model.addAttribute("loginUsername",loginUsername);
		model.addAttribute("role",role);
		model.addAttribute("list",list);
		return "myPage";
	}
}
