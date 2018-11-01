package com.team.springsns.friend.dao;

import java.util.List;

import com.team.springsns.friend.model.FriendRequestInfo;
import com.team.springsns.friend.model.Friends;
import com.team.springsns.model.MemberInfo;
 
public interface FriendsDaoInterface {
	 
	// 친구 목록 가져오는 메서드
	public List getFriendsList(int userNo);
	
	// 받은 친구 신청 목록을 가져오는 메서드
	public List getRequestList(int userNo);
	
	// 친구 페이지를 보여주는 메서드
	public MemberInfo getFriendPage(int userNo);

	// 친구 요청 시 친구 요청 리스트(request)에 추가(등록)하는 메서드
	public int setFriendRequest(FriendRequestInfo requestInfo);
	
	// relation 테이블에서 친구 해제(삭제)하는 메서드
	public int deleteFriend1(Friends friends);
	
	// relation 테이블에서 친구 해제(삭제)하는 메서드
	public int deleteFriend2(Friends friends);
		
	
	// request 테이블에서 요청 대기 삭제하는 메서드
	public int deleteRequest(FriendRequestInfo requestInfo);
	
	// 친구 요청 상태를 확인하는 메서드
	public Friends chkFriend();
	
	// 친구 요청을 수락 시 테이블에 추가하는 메서드 1
	public int setFriendAccept1(Friends friends);

	// 친구 요청을 수락 시 테이블에 추가하는 메서드 2
	public int setFriendAccept2(Friends friends);
	
	// 친구 상태를 체크하는 메서드
	public int chkFriend(Friends friends);

}