package com.example.oauth2client.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.oauth2client.dto.ReservationDto;

@Mapper
public interface ReservationMapper {

	int insertReservation(ReservationDto reservationDto);
	
	List<Map<String,Object>> selectMyReservation(String provider); 
}
