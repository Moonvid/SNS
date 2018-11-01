package com.team.springsns.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.comment.dao.CommentDaoInterface;

public class DeleteCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public void deleteComment(int commentNo) {
		
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		commentDao.deleteComment(commentNo);
		
	}
	
	
}
