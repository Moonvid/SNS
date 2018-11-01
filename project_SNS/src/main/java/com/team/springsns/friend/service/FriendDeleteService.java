package com.team.springsns.friend.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.friend.dao.FriendsDaoInterface;
import com.team.springsns.friend.model.Friends;
 
@Service
public class FriendDeleteService {
 
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private FriendsDaoInterface friendsDao;

	public int deleteMessagae(int followingNo) {
		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);
		Friends friends = new Friends();
		friends.setFriendNo(followingNo);
		return friendsDao.deleteFriend(friends);
	}
}
