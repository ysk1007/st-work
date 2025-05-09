package com.example.mfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mfu.dto.Boardfile;

@Mapper
public interface BoardfileMapper {
	
	// 보드 파일 추가
	Integer insertBoardfile(Boardfile boardfile);
	
	// 보드 파일들 불러오기
	List<Boardfile> selectBoardfile(int boardNo);
	
	// 보드 파일 하나 가져오기
	Boardfile selectBoardfileOne(int boardfileNo);
	
	// 보드 파일 삭제
	Integer deleteBoardfile(int boardfileNo);
}
