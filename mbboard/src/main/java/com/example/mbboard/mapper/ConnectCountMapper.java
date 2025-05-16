package com.example.mbboard.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.mbboard.dto.ConnectCount;

@Mapper
public interface ConnectCountMapper {
	Map<String, Integer> selectConnectCountAll();
	Map<String, Integer> selectConnectCountToday();
	
	// 오늘 날자의 카운팅 있는지 없는지
	String selectConnectDateByKey(ConnectCount cc);	// cc.getMemberRole()
	
	// selectConnectDateByKey 반환값이 없다면
	int insertConnectCount(ConnectCount cc);
	
	// selectConnectDateByKey 반환값이 있다면
	int updateConnectCount(ConnectCount cc);
}
