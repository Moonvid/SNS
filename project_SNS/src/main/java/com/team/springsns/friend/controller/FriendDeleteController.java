package com.team.springsns.friend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.friend.service.FriendDeleteService;

@Controller
public class FriendDeleteController {
  
	@Autowired
	private FriendDeleteService service;

	@RequestMapping("/team/DeleteMessage")
	public ModelAndView deleteMessage(@RequestParam("friendsNo") int followingNo) {
		System.out.println("삭제 컨트롤러 Mapping 완료!");

		ModelAndView modelAndView = new ModelAndView();
		int result = service.deleteMessagae(followingNo);

		if (result == 1) {
			modelAndView.setViewName("redirect:/team/friendsList");
		} else {
			modelAndView.setViewName("main");
		}
		return modelAndView;
	}
}
