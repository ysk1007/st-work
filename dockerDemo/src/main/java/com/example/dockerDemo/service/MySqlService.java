package com.example.dockerDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dockerDemo.mapper.MySqlMapper;

@Service
public class MySqlService {
	@Autowired MySqlMapper mySqlMapper;
	
	public String getMysqlToday() {
		return mySqlMapper.getMysqlToday();
	}
}
