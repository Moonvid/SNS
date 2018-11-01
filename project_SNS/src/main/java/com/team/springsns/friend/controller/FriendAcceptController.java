package com.team.springsns.friend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.friend.model.FriendRequestInfo;
import com.team.springsns.friend.model.Friends;
import com.team.springsns.friend.service.FriendAcceptService;

@Controller
public class FriendAcceptController {
	 
	@Autowired
	private FriendAcceptService acceptService;
	
	@RequestMapping("/friendAccept")
	@ResponseBody
	public String friendAccept(FriendRequestInfo friendRequestInfo, Friends friends) {
		
		System.out.println("friendAccept 진행");
		
		int insertCnt = 0;
		int deleteCnt = 0;
		
		insertCnt = acceptService.friendAccept(friends);
		deleteCnt = acceptService.deleteRequest(friendRequestInfo);
		
		System.out.println("insertCnt의 값 : " + insertCnt );
		System.out.println("accept용 deleteCnt의 값 : " + deleteCnt );
		
		return "team/friendsList";
	}
	
	@RequestMapping("/friendDeny")
	@ResponseBody
	public String friendDeny(FriendRequestInfo friendRequestInfo) {
		
		int deleteCnt = 0;
		
		deleteCnt = acceptService.deleteRequest(friendRequestInfo);
		
		System.out.println("deny용 deleteCnt의 값 : " + deleteCnt);
		
		
		return "team/friendsList";
		
	}
	
	

}
