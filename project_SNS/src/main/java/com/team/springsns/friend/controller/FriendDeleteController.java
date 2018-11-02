package com.team.springsns.friend.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.friend.model.Friends;
import com.team.springsns.friend.service.FriendDeleteService;

@Controller
public class FriendDeleteController {
  
	@Autowired
	private FriendDeleteService deleteService;

	@RequestMapping("/friendRemove")
	@ResponseBody
	public String deleteFriend(Friends friends) {
			System.out.println(friends);
		int deleteCnt = deleteService.deleteFriend(friends);
		
		return "friend/friendsList";

	}
}
