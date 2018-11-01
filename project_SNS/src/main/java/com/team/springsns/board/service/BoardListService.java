package com.team.springsns.board.service;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.board.dao.BoardDao;
import com.team.springsns.board.model.Board;
import com.team.springsns.board.model.BoardListView;

@Service
public class BoardListService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private BoardDao dao;
	
	private static final int BOARD_COUNT_PER_PAGE = 5;

	public BoardListView getBoardList(int pageNumber, String userId) {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		
		int currentPageNumber = pageNumber;
		int boardTotalCount = dao.selectCount(userId);
		List<Board> boardList = null;
		int firstRow = 0;
		int endRow = 0;

		if (boardTotalCount > 0) {
			firstRow = (pageNumber - 1) * BOARD_COUNT_PER_PAGE;
			endRow = BOARD_COUNT_PER_PAGE;
			boardList = dao.selectList(userId, firstRow, endRow);
		} else {
			currentPageNumber = 0;
			boardList = Collections.emptyList();
		}

		return new BoardListView(boardList, boardTotalCount, currentPageNumber, BOARD_COUNT_PER_PAGE, firstRow, endRow);
	}

}
