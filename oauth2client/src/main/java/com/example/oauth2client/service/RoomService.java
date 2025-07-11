package com.example.oauth2client.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oauth2client.mapper.RoomMapper;

@Service
public class RoomService {
	
	@Autowired RoomMapper roomMapper;
	
	/* 룸 조회 */
	public List<Map<String, Object>> selectRoom(Map<String,Object> option){
		return roomMapper.selectRoom(option);
	}
}
