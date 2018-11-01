package com.team.springsns.isgood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.isgood.sevice.CountIsGoodService;

@Controller
public class CountIsGoodController {

	@Autowired
	public CountIsGoodService countIsGoodService;
	
	@RequestMapping("/book/isGoodCnt")
	@ResponseBody
	public int getCountIsGood(@RequestParam("boardNo") int boardNo) {
		System.out.println("isGoodCnt컨트롤러 진입!");
		
		int isGoodCnt = 0;
		
		isGoodCnt = countIsGoodService.getCountIsGood(boardNo);
		
		System.out.println("CountisGoodCnt 컨트롤러 isGoodCnt : "+isGoodCnt);
		
		/*String like= likeCnt+"";*/
		
		return isGoodCnt;
	}
}
