package com.team.springsns.isgood.sevice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.isgood.dao.IsGoodDaoInterface;
import com.team.springsns.isgood.model.IsGoodDTO;

public class IsGoodService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private IsGoodDaoInterface isGoodDao;
	
	@Transactional
	public void insertIsGood(IsGoodDTO isGood) {
		
		isGoodDao = sqlSessionTemplate.getMapper(IsGoodDaoInterface.class);
		
		if(!(isGoodDao.selectIsGood(isGood)==null)) {
			isGoodDao.deleteIsGood(isGood);
			System.out.println("좋아요 취소");
			
			
		}else {
			isGoodDao.insertIsGood(isGood);
		System.out.println("좋아요!");
		}
	}
}
