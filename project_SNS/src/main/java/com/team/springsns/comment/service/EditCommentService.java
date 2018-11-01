package com.team.springsns.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.comment.dao.CommentDaoInterface;

public class EditCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public void editComment(String comment, int commentNo) {
		
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		System.out.println("커맨트 수정 서비스 - " + comment +" : " + "커맨트넘버 : " +commentNo);
		
		commentDao.updateComment(comment, commentNo);
	}
}
