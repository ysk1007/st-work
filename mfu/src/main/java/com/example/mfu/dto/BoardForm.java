package com.example.mfu.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardForm {
	private int boardNo;
	private String boardTitle;
	private List<MultipartFile> boardfile;
}
