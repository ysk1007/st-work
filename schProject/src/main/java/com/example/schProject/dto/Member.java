package com.example.schProject.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Member {
	private String id;
	private String pw;
	private String email;
	private String active;
}
