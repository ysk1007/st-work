package com.example.oauth2client.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.oauth2client.dto.ReservationDto;
import com.example.oauth2client.service.ReservationService;
import com.example.oauth2client.service.RoomService;

@Controller
public class ReservationController {
	@Autowired RoomService roomService;
	@Autowired ReservationService reservationService;
	
	@GetMapping({"/","/reservationList"})
	public String reservationList(Model model, @RequestParam(defaultValue = "") String date, @RequestParam(defaultValue = "AM") String option) {
		
		// 1. 오늘 날짜 문자열로 가져오기 (yyyy-MM-dd)
	    if (date == null || date.isBlank()) {
	        LocalDate today = LocalDate.now();
	        date = today.format(DateTimeFormatter.ISO_DATE);  // "yyyy-MM-dd"
	    }
		
		Map<String,Object> optionMap = new HashMap<>();
		
		optionMap.put("date", date);
		optionMap.put("option", option);
		
		List<Map<String,Object>> list = roomService.selectRoom(optionMap);
		
		model.addAttribute("list",list);
		model.addAttribute("date",date);
		model.addAttribute("option",option);
		
		return "reservationList";
	}
	
	@GetMapping("/addReservation")
	public String addReservation(Model model,
									@RequestParam Integer roomNo,
									@RequestParam String roomName,
									@RequestParam String date, 
									@RequestParam String option) {
		
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
		
		model.addAttribute("loginUsername",loginUsername);
		model.addAttribute("role",role);
		model.addAttribute("roomNo",roomNo);
		model.addAttribute("roomName",roomName);
		model.addAttribute("date",date);
		model.addAttribute("option",option);
		
		return "addReservation";
	}
	
	// 예약 기능
	@PostMapping("/addReservation")
	public String addReservation(ReservationDto reservationDto) {		
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
		
		if(role.equals("NAVER")) {
			reservationDto.setReservationId("mobile");
		}
		else if(role.equals("GOOGLE")) {
			reservationDto.setReservationId("email");
		}
		else if(role.equals("KAKAO")) {
			reservationDto.setReservationId("profile");
		}
		
		System.out.println(reservationDto.toString());
		
		int row = reservationService.insertReservation(reservationDto);
		
		if (row == 1) {
			 return "redirect:/reservationSuccess";
	    } else {
	    	 return "redirect:/reservationFail";
	    }
	}
	
	@GetMapping("/reservationSuccess")
	public String reservationSuccess() {
		return "reservationSuccess";
	}
}
