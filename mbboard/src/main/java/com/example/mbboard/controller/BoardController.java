package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.service.BoardService;
import com.example.mbboard.service.IBoardService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class BoardController {

	@Autowired IBoardService boardService; // 인터페이스 형태로 의존성 주입 -> 디커플링
	
	@GetMapping({"/","boardList"})
	public String boardList(Model model
			, @RequestParam (value="currentPage", defaultValue="1")int currentPage
			, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		
		Page p = new Page(8,currentPage,boardService.countBoardList(searchWord),searchWord);
		List<Board> boardList = boardService.selectBoardListByPage(p);
		model.addAttribute("boardList", boardList);
		model.addAttribute("page", p);

		return "boardList";
	}
	
	@GetMapping("boardOne")
	public String boardOne(Model model, @RequestParam(value="boardNo") int boardNo) {
		Board board = boardService.selectBoardOne(boardNo);
		model.addAttribute("board",board);
		return "boardOne";
	}
	
	@GetMapping("updateBoard")
	public String updateBoard(Model model, @RequestParam(value="boardNo") int boardNo) {
		Board board = boardService.selectBoardOne(boardNo);
		model.addAttribute("board",board);
		return "updateBoard";
	}
	
	@PostMapping("updateBoard")
	public String updateBoard(Board board) {
		int row = boardService.updateBoard(board);
		
		if(row != 1) {
			throw new RuntimeException();
		}
		return "redirect:/boardOne?boardNo=" + board.getBoardNo();
	}
	
	@GetMapping("deleteBoard")
	public String deleteBoard(Board board) {
		int row = boardService.deleteBoard(board);
		
		if(row != 1) {
			throw new RuntimeException();
		}
		
		return "redirect:/";
	}
	
	@GetMapping("insertBoard")
	public String insertBoard() {
		return "insertBoard";
	}
	
	@Transactional
	@PostMapping("insertBoard")
	public String insertBoard(Board board) {
		int row = boardService.insertBoard(board);
		
		if(row != 1) {
			throw new RuntimeException();
		}
		return "redirect:/boardList";
	}
}
