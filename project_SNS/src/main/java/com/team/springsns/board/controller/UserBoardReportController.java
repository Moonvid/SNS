package com.team.springsns.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.board.service.BoardReportService;
import com.team.springsns.model.MemberInfo;

@Controller
@RequestMapping("/board/report")
public class UserBoardReportController {

	@Autowired
	private BoardReportService service;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView report(@RequestParam("boardNo") int boardNo, @RequestParam("userNo") int userNo,
			HttpServletRequest request) {

		MemberInfo loginInfo = (MemberInfo) request.getSession(false).getAttribute("loginInfo");
		String userId = loginInfo.getUserId();

		ModelAndView modelAndView = new ModelAndView();

		// boardNo, userNo 넣어줌!
		service.report(boardNo, userNo);

		// 신고카운트된 값반환해줌!
		int result = service.reportCnt(boardNo);
		int chk = service.reportBool(boardNo);
		
		if (result >= 3) {
			// 신고접수되고 내용 수정해줌!
			service.updateReport(boardNo);
		}

		System.out.println("신고카운트된 갯수" + result);

		modelAndView.addObject("userId", userId);
		modelAndView.addObject("result", result);
		// 메인페이지로 보내줌!
		modelAndView.setViewName("forward:/board/boardList?userId="+userId);
		return modelAndView;

	}

}
