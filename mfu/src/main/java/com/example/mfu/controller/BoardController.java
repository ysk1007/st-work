package com.example.mfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mfu.dto.Board;
import com.example.mfu.dto.BoardForm;
import com.example.mfu.dto.Boardfile;
import com.example.mfu.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("/removeBoard")
	public String removeBoard(@RequestParam(value="boardNo")int boardNo) {
		boardService.removeBoard(boardNo);
		return "redirect:/";
	}
	
	@GetMapping("/removeFile")
	public String removeFile(@RequestParam(value="boardfileNo")int boardfileNo
							,@RequestParam(value="boardNo")int boardNo) {
		
		boardService.removeFile(boardfileNo);
		return "redirect:/boardOne?boardNo="+boardNo;
	}
	
	@GetMapping("/modifyBoard")
	public String modifyBoard(Model model, @RequestParam(value = "boardNo")int boardNo) {
		Board board = boardService.selectBoardOne(boardNo);
		model.addAttribute("board",board);
		return "modifyBoard";
	}
	
	@PostMapping("/modifyBoard")
	public String modifyBoard(BoardForm boardForm, @RequestParam(value = "boardNo")int boardNo) {
		boardService.updateBoard(boardForm);
		return "redirect:/boardOne?boardNo="+boardNo;
	}
	
	@GetMapping("/boardOne")
	public String boardOne(Model model, @RequestParam(value = "boardNo")int boardNo) {
		List<Boardfile> list = boardService.selectBoardfile(boardNo);
		Board board = boardService.selectBoardOne(boardNo);
		model.addAttribute("list",list);
		model.addAttribute("board",board);
		return "boardOne";
	}
	
	@GetMapping({"/","/boardList"})
	public String boardList(Model model) {
		List<Board> list = boardService.selectBoard();
		model.addAttribute("list", list);
		return "boardList";
	}
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "addBoard";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(BoardForm boardForm) {
		log.info(boardForm.toString());
		//log.info("size : " + boardForm.getBoardfile().size());
		boardService.addBoard(boardForm);
		return "redirect:/";
	}
}
