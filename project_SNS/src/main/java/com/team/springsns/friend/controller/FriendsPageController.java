package com.team.springsns.friend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.friend.model.FriendRequestInfo;
import com.team.springsns.model.MemberInfo;
import com.team.springsns.friend.service.FriendRequestService;
import com.team.springsns.friend.service.FriendsViewService;

@Controller
public class FriendsPageController {
	
	@Autowired
	private FriendsViewService viewService;
	
	@Autowired
	private FriendRequestService requestService;
	
	@RequestMapping(value="/team/friendsPage/{userNo}")
	public ModelAndView viewFriendsPage(@PathVariable("userNo") int friendNo, HttpSession session) {
		
		// ModelAndView 메서드 사용을 위한 객체 선언
		ModelAndView mav = new ModelAndView();
		
		// 현재 컨트롤러로 부터 이동할 view단의 default 페이지 주소 설정
		mav.setViewName("team/friendsPage");
		
		System.out.println(viewService.viewFriendPage(friendNo));
		
		// 로그인 시 저장된 로그인 세션 정보를 MemberInfo 타입으로 새로 저장
		MemberInfo loginInfo = (MemberInfo)session.getAttribute("loginInfo");
		
		// MemberInfo 객체 형식으로 가져온 친구 정보를 view단에 friendInfo라고 넘겨준다.
		MemberInfo friendInfo = viewService.viewFriendPage(friendNo); // 친구 목록에 있는 친구 정보를 클릭하여 전달받은 친구의 userNo 값으로 친구 정보를 가져옴 
		mav.addObject("friendInfo", friendInfo);
		session.setAttribute("friendInfo", friendInfo);
		
		return mav;
	}
}