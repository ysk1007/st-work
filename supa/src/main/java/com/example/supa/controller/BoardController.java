package com.example.supa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.supa.dto.BoardDto;
import com.example.supa.service.BoardService;

@Controller
public class BoardController {

	BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/")
	public String boardList(Model model) {
		List<BoardDto> boardList = boardService.selectBoardList();
		model.addAttribute("boardList",boardList);
		return "boardList";
	}
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "addBoard";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(BoardDto boardDto) {
		boardService.addBoard(boardDto);
		return "redirect:/";
	}
	
	@GetMapping("/editBoard")
	public String editBoard(Model model, @RequestParam String id) {
		BoardDto boardDto = boardService.selectBoardOne(Integer.parseInt(id));
		model.addAttribute("board",boardDto);
		return "editBoard";
	}
	
	@PostMapping("/editBoard")
	public String editBoard(BoardDto boardDto) {
		boardService.editBoard(boardDto);
		return "redirect:/";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@RequestParam String id) {
		boardService.deleteBoard(Integer.parseInt(id));
		return "redirect:/";
	}
}
