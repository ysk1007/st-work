package com.example.oauth2client.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {

	public List<Map<String, Object>> selectRoom(Map<String, Object> option);	// 룸 조회
}
