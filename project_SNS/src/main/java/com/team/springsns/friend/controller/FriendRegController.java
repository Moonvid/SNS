package com.team.springsns.friend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.friend.model.FriendRequestInfo;
import com.team.springsns.friend.service.FriendRequestService;

@Controller
public class FriendRegController {
  
	@Autowired
	private FriendRequestService requestService;

	@RequestMapping("/friendReg")
	@ResponseBody
	public String setFriendReg(FriendRequestInfo friendRequestInfo, Model model) {
		System.out.println("setFriendReg 접속");
		System.out.println(friendRequestInfo);
		int result = requestService.friendRequest(friendRequestInfo);
//		model.addAttribute("response", result);
		System.out.println(result + "");
		return result + "";

	}
	
	@RequestMapping("/friendRegCancel")
	@ResponseBody
	public String friendRegCancel(FriendRequestInfo friendRequestInfo) {
		
		System.out.println("friendRegCancel 접속");
		
		int result = requestService.deleteRequest(friendRequestInfo);
		
		return result + "";
	}
}
