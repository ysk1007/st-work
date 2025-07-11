package com.example.oauth2client.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oauth2client.dto.ReservationDto;
import com.example.oauth2client.mapper.ReservationMapper;

@Service
public class ReservationService {
	
	@Autowired ReservationMapper reservationMapper;
	
	public List<Map<String,Object>> selectMyReservation(String provider){
		return reservationMapper.selectMyReservation(provider);
	}
	
	public int insertReservation(ReservationDto reservationDto) {
		return reservationMapper.insertReservation(reservationDto);
	}
}
