package com.team.springsns.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.member.service.MemberLoginService;

@Controller
public class MemberLoginController {

	@Autowired
	private MemberLoginService service;

	// 로그인 처리하기
	@RequestMapping(value = "/", method = RequestMethod.POST)
	// @RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "userPassword", required = true) String userPassword, HttpSession session)
			throws SQLException {
		System.out.println("1111");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("team/loginFail"); // 실패하는걸 디폴트로 하면 if문에서 else 안써도 됨

		if (userId != null && userPassword != null) {

			if (service.login(userId, userPassword, session)) {

				// 정상적 로그인 & 관리자 계정일때
				if (userId.equals("manager@gmail.com")) {
					modelAndView.setViewName("team/index");

				} else {
					// 정상적으로 들어왔지만 일반 계정일때
					// modelAndView.setViewName("team/team");
					modelAndView.setViewName("team/team");
				}
			}
		}
		return modelAndView;
	}
}
