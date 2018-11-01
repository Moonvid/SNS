package com.team.springsns.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.comment.dao.CommentDaoInterface;
import com.team.springsns.comment.model.CommentDTO;

public class GetCommentListService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public List<CommentDTO> getCommentList(int boardNo){
	
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>(); 
				
		commentList = commentDao.selectCommentList(boardNo);
		
		return commentList;
	}
	
}
