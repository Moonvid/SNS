package com.team.springsns.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.comment.dao.CommentDaoInterface;
import com.team.springsns.comment.model.CommentDTO;

@Service
public class GetCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	public CommentDTO getComment(int commentNo) {
		
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		CommentDTO comment = new CommentDTO();
		
		comment = commentDao.getComment(commentNo);
		
		return comment;
	}
}
