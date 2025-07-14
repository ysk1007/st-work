package com.example.dockerDemo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MySqlMapper {
	String getMysqlToday();
}
