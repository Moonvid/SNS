package com.team.springsns.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.board.model.BoardListView;
import com.team.springsns.board.service.BoardListService;
import com.team.springsns.isgood.model.CountIsGoodDTO;
import com.team.springsns.isgood.sevice.GetIsGoodCountAllService;

@Controller
public class UserBoardListController {

	@Autowired
	private BoardListService service;
	
	@Autowired
	private GetIsGoodCountAllService getIsGoodCountAllService;
	
	@RequestMapping(value="board/boardList", method = RequestMethod.GET)
	public ModelAndView getBoardList(HttpServletRequest request) {
		System.out.println("@@@s");
		String pageNumberStr = request.getParameter("page");
		String userId = request.getParameter("userId");

		List<CountIsGoodDTO> isGoodList = new ArrayList<CountIsGoodDTO>();
		
		isGoodList = getIsGoodCountAllService.getIsGoodCountAll();
		
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		BoardListView viewData = service.getBoardList(pageNumber, userId);
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board/boardList");
		modelAndView.addObject("viewData", viewData);
		//modelAndView.addObject("userId", userId);
		modelAndView.addObject("isGoodList", isGoodList);

		return modelAndView;
	}


}
