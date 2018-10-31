package com.team.springsns.comment.dao;

import java.util.List;

import com.team.springsns.model.CommentDTO;

public interface CommentDaoInterface {
	
	public void insertComment(CommentDTO commentDTO);
	public List<CommentDTO> selectCommentList(int boardNo);
	public void deleteComment(int commentNo);
	public void deleteCommentAll(int boardNo);
	public void updateComment(String commentCont, int commentNo);
}
