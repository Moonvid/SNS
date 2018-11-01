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

	public int deleteFriend(Friends friends) {
		friendsDao = sqlSessionTemplate.getMapper(FriendsDaoInterface.class);
		
		int deleteCnt1 = 0;
		int deleteCnt2 = 0;
		int total = 0;
		
		deleteCnt1 = friendsDao.deleteFriend1(friends);
		deleteCnt2 = friendsDao.deleteFriend2(friends);
		
		if(deleteCnt1==1 && deleteCnt1==deleteCnt2)
			total = 1;
		
		return total;
	}
}
