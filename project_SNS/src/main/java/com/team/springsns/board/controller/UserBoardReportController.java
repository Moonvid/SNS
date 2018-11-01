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
	public int report(@RequestParam("boardNo") int boardNo, @RequestParam("userNo") int userNo, HttpServletRequest request) {
		
		/*String userId = request.getParameter("userId");*/
/*		MemberInfo loginInfo = (MemberInfo) request.getSession(false).getAttribute("loginInfo");
		String userId= loginInfo.getUserId();
		ModelAndView modelAndView = new ModelAndView();*/
		
		return service.report(boardNo, userNo);

/*		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList?userId=" + userId);
		
		return modelAndView;*/
	}

}
