package com.team.springsns.board.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.board.dao.BoardDao;
import com.team.springsns.board.model.Board;

@Service
public class BoardEditService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private BoardDao dao;

	@Transactional
	public int edit(Board board, HttpServletRequest request) throws IllegalStateException, IOException {
		dao = sqlSessionTemplate.getMapper(BoardDao.class);
		String uploadUri = "/uploadfile";

		// uploadUri 경로의 시스템 경로
		String dir = request.getSession().getServletContext().getRealPath(uploadUri);

		// DB 저장용 파일 이름, 물리적 저장할때의 이름
		String imgName = "";
		if (!board.getBoardPhotoFile().isEmpty()) {
			imgName = board.getBoardNo() + "_" + board.getBoardPhotoFile().getOriginalFilename();

			board.getBoardPhotoFile().transferTo(new File(dir, imgName));

			board.setBoardPhoto(imgName);
		}

		return dao.edit(board);
	}
	
	public Board editForm(int boardno) {
		BoardDao dao = sqlSessionTemplate.getMapper(BoardDao.class);
		return dao.select(boardno);
	}
}
