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
	
/*	public int getReport(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportCnt(boardNo);
	}*/
	
	//게시글 내용 바꿈
	public int updateReport(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.report(boardNo);
	}
	
	// 보드넘버, 유저넘버 넣어줌!
	@Transactional
	public int report(int boardNo, int userNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportUp(boardNo, userNo);
	}
	
	// 신고건수 반환
	public int reportCnt(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportcntCnt(boardNo);
	}
	
	// 신고받으면 보드넘버 넣어줌! report_cnt테이블에
	public int reportPlus(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportcntPlus(boardNo);
	}
	
	// 신고받으면 신고카운트 +1해줌
	public int reportUp(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportcntUp(boardNo);
	}
	
	public int reportBool(int boardNo) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.reportBoolean(boardNo);
	}

}
