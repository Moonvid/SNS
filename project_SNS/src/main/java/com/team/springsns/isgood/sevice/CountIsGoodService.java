package com.team.springsns.isgood.sevice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.isgood.dao.IsGoodDaoInterface;
import com.team.springsns.isgood.model.CountIsGoodDTO;

@Service
public class CountIsGoodService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private IsGoodDaoInterface isGoodDao;
	
	@Transactional
	public int getCountIsGood(int boardNo) {
		
		CountIsGoodDTO isGoodCnt;
		
		isGoodDao = sqlSessionTemplate.getMapper(IsGoodDaoInterface.class);
		
		isGoodCnt = isGoodDao.getCountIsGood(boardNo);

		int onlyIsGoodCnt = 0;
		
		if(isGoodCnt==null) {
			onlyIsGoodCnt = 0;
		} else {
		onlyIsGoodCnt = isGoodCnt.getIsGoodCnt();
		}
		return onlyIsGoodCnt;
	}
}
