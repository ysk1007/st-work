package com.example.ssecurity.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.ssecurity.domain.UserDomain;

@Mapper
public interface UserMapper {
	// 회원조회
	UserDomain selectByUsername(String username);
	
	// 회원가입
	int insert(UserDomain userDomain);
	
	// 회원탈퇴
	int delete(UserDomain userDomain);
	
	// 회원수정
	int update(UserDomain userDomain);
}
