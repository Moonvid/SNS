package com.team.springsns.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.board.service.BoardDeleteService;

@Controller
public class UserBoardDeleteController {
	@Autowired
	private BoardDeleteService service;

	@RequestMapping(value = "board/delete", method = RequestMethod.GET)
	public ModelAndView getDeleteForm(@RequestParam(value = "userid", required = false) String userId, @RequestParam("boardno") int boardno) {
		ModelAndView modelAndView = new ModelAndView();
		
		service.delete(boardno);
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList");
		
		
		return modelAndView;
	}
}
