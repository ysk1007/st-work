package com.example.mfu.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.mfu.dto.Board;
import com.example.mfu.dto.BoardForm;
import com.example.mfu.dto.Boardfile;
import com.example.mfu.exception.AddBoardException;
import com.example.mfu.mapper.BoardMapper;
import com.example.mfu.mapper.BoardfileMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardService {
	@Autowired BoardMapper boardMapper;
	@Autowired BoardfileMapper boardfileMapper;
	
	public void removeBoard(int boardNo) {
		// 1) 파일 전부 삭제
		List<Boardfile> list = boardfileMapper.selectBoardfile(boardNo);
		
		for(Boardfile f : list) {
			File file = new File("c:/project/upload/" + f.getFilename());
			
			if(file.exists()) {
				file.delete();
			}
			// 2) boardfile 들 삭제
			int deleteBoardFileRow = boardfileMapper.deleteBoardfile(f.getBoardfileNo());
			
			if(deleteBoardFileRow != 1) {
				throw new RuntimeException();
			}
		}
		
		// 3) 최종 게시글 board 삭제
		int deleteBoardRow = boardMapper.deleteBoard(boardNo);
		
		if(deleteBoardRow != 1) {
			throw new RuntimeException();
		}
	}
	
	public void removeFile(int boardfileNo) {
		// 1) 파일 삭제 먼저
		Boardfile boardfile = boardfileMapper.selectBoardfileOne(boardfileNo);
		//log.info("boardfile.toString() : " + boardfile.toString());
		File file = new File("c:/project/upload/" + boardfile.getFilename());
		
		if(file.exists()) {
			file.delete();
		}
		
		// 2) boardfile 삭제
		int deleteFileRow = boardfileMapper.deleteBoardfile(boardfileNo);
		//log.info("deleteFileRow : " + deleteFileRow);
		if(deleteFileRow != 1) {
			throw new RuntimeException();
		}
	}
	
	// 보드 제목 수정
	public void updateBoard(BoardForm boardform) {
		boardMapper.updateBoardTitle(boardform);
	}
	
	// 보드 리스트 가져오기
	public List<Board> selectBoard(){
		return boardMapper.selectBoard();
	}
	
	// 보드 하나 가져오기
	public Board selectBoardOne(int boardNo){
		return boardMapper.selectBoardOne(boardNo);
	}
	
	// 보드의 파일들 가져오기
	public List<Boardfile> selectBoardfile(int boardNo){
		return boardfileMapper.selectBoardfile(boardNo);
	}
	
	// 보드 추가
	public void addBoard(BoardForm boardForm) {
		// 1) board 추가
		Board board = new Board();
		board.setBoardTitle(boardForm.getBoardTitle());		// board.getBoardNo() => 0
		int addBoardRow = boardMapper.insertBoard(board);	// After => board.setBoardNo(key)
		log.info("board.getBoardNo() : "+board.getBoardNo());
		
		if(addBoardRow != 1) {
			throw new AddBoardException();	// RuntimeException 예외 처리를 안 해도 되는 예외를 발생 시킨다.
		}
		
		// 2) boardfile 추가
		if(boardForm.getBoardfile() != null){
			for(MultipartFile f : boardForm.getBoardfile()) {	// getBoardfile size만큼 입력
				Boardfile bf = new Boardfile();
				String filename = UUID.randomUUID().toString().replace("-", "");
				filename += f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf(".")); // UUID 문자열 + .확장자
				bf.setFilename(filename);
				bf.setBoardNo(board.getBoardNo());
				bf.setFiletype(f.getContentType());
				int addBoardfileRow = boardfileMapper.insertBoardfile(bf);
				
				if(addBoardfileRow != 1) {
					throw new AddBoardException();	// RuntimeException 예외 처리를 안 해도 되는 예외를 발생 시킨다.
				}
				
				// 3) 파일 저장			
				File emptyFile = new File("c:/project/upload/"+filename);
				// f안에 파일스트림을 emptyFile로 이동
				try {
					f.transferTo(emptyFile);
				} catch (Exception e) {
					throw new AddBoardException();	// RuntimeException 예외 처리를 안 해도 되는 예외를 발생 시킨다.
				}
			}
		}
	}
}
