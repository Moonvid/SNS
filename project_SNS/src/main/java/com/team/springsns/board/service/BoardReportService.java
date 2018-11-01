package com.team.springsns.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.board.dao.BoardDao;

@Service
public class BoardReportService {

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private BoardDao dao;
	
	public int getReport(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportCnt(boardNo);
	}
	
	//게시글 내용 바꿈
	public int updateReport(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.report(boardNo);
	}
	
	@Transactional
	public int report(int boardNo, int userNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportUp(boardNo, userNo);
		
	}

}
