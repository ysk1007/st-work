package com.example.supa.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NowMapper {
	String selectNow();
}
