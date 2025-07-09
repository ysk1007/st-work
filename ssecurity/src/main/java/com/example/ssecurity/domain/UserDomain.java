package com.example.ssecurity.domain;

import lombok.Data;

@Data
public class UserDomain {
	private String username;
	private String password;
	private String role;
}
