package com.team.springsns.friend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.friend.model.FriendRequestInfo;
import com.team.springsns.friend.model.FriendsListView;
import com.team.springsns.model.MemberInfo;
import com.team.springsns.friend.service.FriendRequestService;
import com.team.springsns.friend.service.FriendsListService;

@Controller
public class FriendsListController {
	 
	@Autowired
	private FriendsListService ListService;
	 
	@Autowired
	private FriendRequestService requestService;
	
	@RequestMapping("/friend/friendsList")
	public ModelAndView getFriendsList(HttpSession session) {
		
		// ModelAndView 메서드 사용을 위한 객체 선언
		ModelAndView mav = new ModelAndView();
		
		// 로그인 시 저장된 로그인 세션 정보를 MemberInfo 타입으로 새로 저장(이 정보를 가지고 친구목록/받은 친구 요청 목록을 가져온다)
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		
		/*
		// 친구 목록을 가져오기 위한 FriendListView 타입의 객체 선언
		FriendsListView listView = new FriendsListView();
		
		// 친구요청 목록을 가져오기 위한 FriendRequestInfo 타입의 객체 선언
		FriendRequestInfo requestInfo = new FriendRequestInfo();
		*/
		
		 
		// 가져온 친구 목록이 있으면 ModelAndView 객체에 friendsList란 이름으로 객체를 저장하여 view 단에 넘겨준다.
		if(!ListService.viewFriendsList(loginInfo.getUserNo()).isEmpty()) {
				mav.addObject("friendsList", ListService.viewFriendsList(loginInfo.getUserNo()));
		}
		
		// 가져온 친구요청 목록이 있으면 ModelAndView 객체에 friendsList란 이름으로 객체를 저장하여 view 단에 넘겨준다.
		if(!requestService.viewRequestList(loginInfo.getUserNo()).isEmpty()) {
			mav.addObject("requestList", requestService.viewRequestList(loginInfo.getUserNo()));			
		}
		
		mav.setViewName("friend/friendsList");
		
		
		
		return mav;
		
	}

}