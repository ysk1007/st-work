package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardService implements IBoardService{
	@Autowired BoardMapper boardMapper;	// 인터페이스 형태로 의존성 주입 -> 디커플링
	
	public int countBoardList(String searchWord) {
		return boardMapper.countBoardList(searchWord);
	}
	
	public List<Board> selectBoardListByPage(Page p){
		return boardMapper.selectBoardListByPage(p);
	}
	
	public int updateBoard(Board board) {
		return boardMapper.updateBoard(board);
	}
	
	public int deleteBoard(Board board) {
		return boardMapper.deleteBoardByKey(board);
	}

	public int insertBoard(Board board) {
		return boardMapper.insertBoard(board);
	}
	
	public Board selectBoardOne(int boardNo) {
		return boardMapper.selectBoardOne(boardNo);
	}
}
