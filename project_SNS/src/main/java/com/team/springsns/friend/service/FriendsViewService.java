package com.team.springsns.friend.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.friend.dao.FriendsDaoInterface;
import com.team.springsns.friend.model.Friends;
import com.team.springsns.model.MemberInfo;
 
@Service
public class FriendsViewService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private FriendsDaoInterface friendsDao;
	  
	// 친구 페이지를 보여주는 메서드
	public MemberInfo viewFriendPage(int userNo) {
		
		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);
		
		MemberInfo friendInfo = friendsDao.getFriendPage(userNo);
		
		return friendInfo;
		
	}
	
	public int chkFriend(Friends friends) {
		
		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);
		
		int chkCnt = 0;
		
		chkCnt = friendsDao.chkFriend(friends);
		
		return chkCnt;
	}
	

}