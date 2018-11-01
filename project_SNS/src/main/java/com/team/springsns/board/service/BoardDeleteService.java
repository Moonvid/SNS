package com.team.springsns.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.board.dao.BoardDao;
import com.team.springsns.isgood.dao.IsGoodDaoInterface;

@Service
public class BoardDeleteService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private BoardDao dao;
	
	@Autowired
	private IsGoodDaoInterface isGoodDao;
	
	public void delete(int boardno) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		dao.select(boardno);
		dao.delete(boardno);
		
		isGoodDao = sqlSessionTemplate.getMapper(IsGoodDaoInterface.class);
		
		isGoodDao.deleteIsGoodAll(boardno);
	}

}
