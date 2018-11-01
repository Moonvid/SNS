package com.team.springsns.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberProfileController {
	
	@RequestMapping("/team/profile")
	public String getProfile() {
				
		return "team/profile";
	}
}
