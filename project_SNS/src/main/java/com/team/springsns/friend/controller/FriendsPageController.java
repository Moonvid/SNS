package com.team.springsns.friend.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.board.model.BoardListView;
import com.team.springsns.board.service.BoardListService;
import com.team.springsns.friend.model.Friends;
import com.team.springsns.friend.service.FriendRequestService;
import com.team.springsns.friend.service.FriendsViewService;
import com.team.springsns.isgood.model.CountIsGoodDTO;
import com.team.springsns.isgood.sevice.GetIsGoodCountAllService;
import com.team.springsns.model.MemberInfo;

@Controller
public class FriendsPageController {

	@Autowired
	private FriendsViewService viewService;

	@Autowired
	private FriendRequestService requestService;
	
	@Autowired
	private BoardListService service;
	
	@Autowired
	private GetIsGoodCountAllService getIsGoodCountAllService;

	@RequestMapping(value = "/friend/friendsPage/{userNo}")
	public ModelAndView viewFriendsPage(@PathVariable("userNo") int friendNo, HttpSession session, HttpServletRequest request) {

		// ModelAndView 메서드 사용을 위한 객체 선언
		ModelAndView mav = new ModelAndView();

		// 현재 컨트롤러로 부터 이동할 view단의 default 페이지 주소 설정
		mav.setViewName("friend/friendsPage");
		System.out.println("하이");
		System.out.println(viewService.viewFriendPage(friendNo));

		// 로그인 시 저장된 로그인 세션 정보를 MemberInfo 타입으로 새로 저장
		MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginInfo");

		Friends friends = new Friends(loginInfo.getUserNo(), friendNo);

		int chkFriend = viewService.chkFriend(friends);

		// MemberInfo 객체 형식으로 가져온 친구 정보를 view단에 friendInfo라고 넘겨준다.
		MemberInfo friendInfo = viewService.viewFriendPage(friendNo); // 친구 목록에 있는 친구 정보를 클릭하여 전달받은 친구의 userNo 값으로 친구
																		// 정보를 가져옴
		mav.addObject("friendInfo", friendInfo);

		mav.addObject("friendRequestInfo", requestService.viewRequestList(friendNo));
		session.setAttribute("friendInfo", friendInfo);

		mav.addObject("chkFriends", chkFriend);
		
		///////////////////////////// 친구 페이지 게시글 표시 /////////////////////////////////////////////////////////////////////////////////////////
		
		String pageNumberStr = request.getParameter("page");
		
		List<CountIsGoodDTO> isGoodList = new ArrayList<CountIsGoodDTO>();
		
		isGoodList = getIsGoodCountAllService.getIsGoodCountAll();
		
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		BoardListView viewData = service.getBoardList(pageNumber, friendInfo.getUserId());
		
		mav.addObject("viewData", viewData);
		mav.addObject("isGoodList", isGoodList);
		

		return mav;
	}

}