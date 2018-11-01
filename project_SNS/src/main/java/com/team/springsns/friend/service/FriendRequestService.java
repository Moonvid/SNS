package com.team.springsns.friend.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.friend.dao.FriendsDaoInterface;
import com.team.springsns.friend.model.FriendRequestInfo;
import com.team.springsns.friend.model.Friends;

@Service
public class FriendRequestService {
 
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private FriendsDaoInterface friendsDao;

	// 친구 요청 테이블에 친구 요청을 넣는 메서드
	public int friendRequest(FriendRequestInfo requestInfo) {

		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);

		int resultCnt = 0;

		resultCnt = friendsDao.setFriendRequest(requestInfo);

		return resultCnt;
	}

	// 받은 친구 요청 리스트를 가져오는 메서드
	public List viewRequestList(int userNo) {

		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);

		List<FriendRequestInfo> requestList = friendsDao.getRequestList(userNo);

		System.out.println(userNo);

		return requestList;

	}

	// 친구 요청을 취소(삭제)하는 메서드
	public int deleteRequest(FriendRequestInfo requestInfo) {

		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);

		int deleteCnt = 0;

		deleteCnt = friendsDao.deleteRequest(requestInfo);

		return deleteCnt;
	}

}
