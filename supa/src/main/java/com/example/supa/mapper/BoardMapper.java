package com.example.supa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.supa.dto.BoardDto;

@Mapper
public interface BoardMapper {
	
	List<BoardDto> selectBoardList();
	BoardDto selectBoardOne(int id);
	int addBoard(BoardDto boardDto);
	int editBoard(BoardDto boardDto);
	int deleteBoard(int id);
}
