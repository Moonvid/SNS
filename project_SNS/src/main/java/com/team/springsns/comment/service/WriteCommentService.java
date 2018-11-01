package com.team.springsns.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.comment.dao.CommentDaoInterface;
import com.team.springsns.comment.model.CommentDTO;

@Service
public class WriteCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public void writeComment(CommentDTO commentDTO) {
		System.out.println("라이트코멘트서비스 진입");
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		System.out.println("코멘트서비스 - 코멘트디티오 : "+commentDTO);
		
		commentDao.insertComment(commentDTO);
		System.out.println("인서트코멘트!");
	}
}
