package com.example.ssecurity.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ssecurity.domain.UserDomain;
import com.example.ssecurity.dto.UserDto;
import com.example.ssecurity.mapper.UserMapper;

@Service
public class UserService {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserMapper userMapper;
	
	public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserMapper userMapper) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userMapper = userMapper;
	}
	
	public void addUser(UserDto userDto) {
		if(userMapper.selectByUsername(userDto.getUsername()) != null) {
			System.out.println(userDto.getUsername() + " 사용자 이름이 존재 합니다.");
			// throw new RuntimeException("");
			return;
		}
		
		// dto -> domain
		UserDomain userDomain = new UserDomain();
		
		userDomain.setUsername(userDto.getUsername());
		userDomain.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userDomain.setRole("ROLE_USER");
		userMapper.insert(userDomain);
	}
	
	public boolean modifyUser(UserDto userDto, String newPassword) {
		UserDomain userDomain = userMapper.selectByUsername(userDto.getUsername());
		
		// 암호화된 비밀번호와, 입력한 비밀번호가 일치하는지 확인
		boolean match = bCryptPasswordEncoder.matches(userDto.getPassword(), userDomain.getPassword());
		
		if(match) {	// 옳바르게 입력 했다면
			
			// 새로운 비밀번호로 저장( 새로운 비밀번호 암호화 )
			userDomain.setPassword(bCryptPasswordEncoder.encode(newPassword));
			userMapper.update(userDomain);
			return true;
		}
		else {
			
			// 실패
			System.out.println("비밀번호가 맞지 않습니다");
			// throw new RuntimeException("");
			return false;
		}
		
	}
	
	public boolean deleteUser(UserDto userDto){
		UserDomain userDomain = userMapper.selectByUsername(userDto.getUsername());
		
		// 암호화된 비밀번호와, 입력한 비밀번호가 일치하는지 확인
		boolean match = bCryptPasswordEncoder.matches(userDto.getPassword(), userDomain.getPassword());
		
		if(match) {	// 옳바르게 입력 했다면
			userMapper.delete(userDomain);
			return true;
		}
		else {
			return false;
		}
	}
}
