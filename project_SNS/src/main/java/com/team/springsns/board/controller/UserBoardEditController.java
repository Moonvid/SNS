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
import com.team.springsns.board.service.BoardEditService;

@Controller
public class UserBoardEditController {

	@Autowired
	private BoardEditService service;

	@RequestMapping(value = "board/edit", method = RequestMethod.GET)
	public ModelAndView getEditForm(@RequestParam("boardno") int boardno) {

		ModelAndView modelAndView = new ModelAndView();
		Board board = service.editForm(boardno);

		modelAndView.setViewName("board/editForm");
		modelAndView.addObject("board", board);

		return modelAndView;
	}
	
	@RequestMapping(value = "board/edit", method = RequestMethod.POST)
	public ModelAndView editBoard(@RequestParam(value = "userId", required = false) String userId, Board board, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList");
		
		service.edit(board, request);
		return modelAndView;
	}
}
