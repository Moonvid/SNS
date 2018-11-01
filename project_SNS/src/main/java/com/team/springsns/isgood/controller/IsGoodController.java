package com.team.springsns.isgood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.isgood.model.IsGoodDTO;
import com.team.springsns.isgood.sevice.CountIsGoodService;
import com.team.springsns.isgood.sevice.IsGoodService;

@Controller
public class IsGoodController {

	@Autowired
	private IsGoodService isGoodService;
	
	@Autowired
	private CountIsGoodService countIsGoodService;
	
	@RequestMapping("/board/isGoodBoard")
	@ResponseBody
	public String isGood(@RequestParam("boardNo") int boardNo,
									@RequestParam("userNo") int userNo) {
		
		int isGoodCnt=0;
		
		IsGoodDTO isGood = new IsGoodDTO();
	
		isGood.setBoardNo(boardNo);
		isGood.setUserNo(userNo);
		
		isGoodService.insertIsGood(isGood);
		isGoodCnt = countIsGoodService.getCountIsGood(boardNo); 
		
		// modelAndView.setViewName("redirect:/book/bookList");
		
		String isGoodCntStr = isGoodCnt+"";
		
		return isGoodCntStr;
	}
}
