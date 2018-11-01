package com.team.springsns.friend.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.friend.dao.FriendsDaoInterface;
import com.team.springsns.friend.model.Friends;

@Service
public class FriendsListService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private FriendsDaoInterface friendsDao;
	
	
	public List viewFriendsList(int userNo) {
		
		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);
		
		List<Friends> friendsList = friendsDao.getFriendsList(userNo);
		System.out.println(friendsList);
		
		return friendsList;
	}

}