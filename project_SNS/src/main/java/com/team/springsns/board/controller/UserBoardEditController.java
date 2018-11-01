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
		//boardno에 해당하는 Board 객체를 board에 저장
		Board board = service.editForm(boardno);

		modelAndView.setViewName("board/editForm");
		modelAndView.addObject("board", board);

		return modelAndView;
	}
	
	@RequestMapping(value = "board/edit", method = RequestMethod.POST)
	public ModelAndView editBoard(@RequestParam(value = "userId", required = false) String userId, @RequestParam(value="page", required=false) int page, Board board, HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("edit controller post: "+userId+"_"+page);
		
		service.edit(board, request);
		//modelAndView.addObject("page", page);
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList");
		
		return modelAndView;
	}
}
