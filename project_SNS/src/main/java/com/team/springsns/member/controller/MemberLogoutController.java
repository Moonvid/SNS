package com.team.springsns.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberLogoutController {

	@RequestMapping("/team/logout")
	public String logout(HttpSession session) {
		
		// 세션의 종료
		session.invalidate();
		
		return "redirect:/";		
	}
	
	
	
}
