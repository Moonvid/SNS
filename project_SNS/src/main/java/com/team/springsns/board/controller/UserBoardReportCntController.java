package com.team.springsns.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.board.service.BoardReportService;

@Controller
@RequestMapping("/reportcnt")
public class UserBoardReportCntController {

	@Autowired
	private BoardReportService service;
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int reportCnt(@RequestParam("boardNo") int boardNo) {
		
		// 업데이트해줌 카운트 + 1
		// 업데이트됐으면 1값반환될듯..?
		return service.reportUpdate(boardNo);
		
		
	}

}
