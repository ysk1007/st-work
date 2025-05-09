package com.example.mfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mfu.dto.Board;
import com.example.mfu.dto.BoardForm;

@Mapper
public interface BoardMapper {
	
	// 보드 제목 수정
	void updateBoardTitle(BoardForm boardForm);
	
	// 보드 삭제
	Integer deleteBoard(int boardNo);
	
	// 보드 추가
	Integer insertBoard(Board board);
	
	// 게시글 목록 조회
	List<Board> selectBoard();
	
	// 게시글 하나 조회
	Board selectBoardOne(int boardNo);
}
