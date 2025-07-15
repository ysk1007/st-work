package com.example.supa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.supa.dto.BoardDto;
import com.example.supa.mapper.BoardMapper;

@Service
public class BoardService {

	BoardMapper boardMapepr;
	
	public BoardService(BoardMapper boardMapepr){
		this.boardMapepr = boardMapepr;
	}
	
	public List<BoardDto> selectBoardList(){
		return this.boardMapepr.selectBoardList();
	}
	
	public BoardDto selectBoardOne(int id) {
		return this.boardMapepr.selectBoardOne(id);
	}
	
	public int addBoard(BoardDto boardDto) {
		return this.boardMapepr.addBoard(boardDto);
	}
	
	public int editBoard(BoardDto boardDto) {
		return this.boardMapepr.editBoard(boardDto);
	}
	
	public int deleteBoard(int id) {
		return this.boardMapepr.deleteBoard(id);
	}
}
