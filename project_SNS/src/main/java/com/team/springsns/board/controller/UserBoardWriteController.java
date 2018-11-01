package com.team.springsns.board.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.board.model.Board;
import com.team.springsns.board.service.BoardWriteService;

@Controller
public class UserBoardWriteController {
	@Autowired
	private BoardWriteService service;
	
	@RequestMapping(value="board/write", method = RequestMethod.GET)
	public String getWriteForm() {
		return "board/writeForm";
	}
	
	
	@RequestMapping(value="board/write", method = RequestMethod.POST)
	public ModelAndView writeBoard(@RequestParam(value = "userId", required = false) String userId, Board board, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView modelAndView = new ModelAndView();
		
		int resultCnt = service.write(board, request);
		System.out.println(userId);
		
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList");
		
		if(resultCnt ==0) {
			modelAndView.setViewName("board/writeFail");
		}
		
		
		return modelAndView;
	}
}
