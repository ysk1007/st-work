package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;

public interface IBoardService {
	int countBoardList(String searchWord);
	List<Board> selectBoardListByPage(Page p);
	
	int updateBoard(Board board);
	
	Board selectBoardOne(int boardNo);
	int insertBoard(Board board);
	int deleteBoard(Board board);
}
