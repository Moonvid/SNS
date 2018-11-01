package com.team.springsns.friend.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.friend.dao.FriendsDaoInterface;
import com.team.springsns.friend.model.FriendRequestInfo;
import com.team.springsns.friend.model.Friends;

@Service
public class FriendAcceptService {
	 
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private FriendsDaoInterface friendsDao;
	
	public int friendAccept(Friends friends) {
		
		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);
		
		int resultCnt1 = 0;
		int resultCnt2 = 0;
		int totalCnt = 0;
		
		resultCnt1 = friendsDao.setFriendAccept1(friends);
		resultCnt2 = friendsDao.setFriendAccept2(friends);
		
		if(resultCnt1==1 && resultCnt1==resultCnt2)
		{
			totalCnt = resultCnt1;
		}
		
		return totalCnt;
	}
	
	public int deleteRequest(FriendRequestInfo requestInfo) {
		
		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);
		
		int deleteCnt = 0;
		
		deleteCnt = friendsDao.deleteRequest(requestInfo);
		
		
		return deleteCnt;
	}

}
