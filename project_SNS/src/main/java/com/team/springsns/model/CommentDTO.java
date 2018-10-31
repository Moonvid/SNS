package com.team.springsns.model;

import java.util.Date;

public class CommentDTO {

	private int commentNo; // 덧글번호
	private int boardNo; // 원 게시글 번호
	private String userId; // 덧글 작성자 아이디
	private String commentCont; // 덧글 내용
	private Date commentDate; // 덧글 작성시간

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentCont() {
		return commentCont;
	}

	public void setCommentCont(String commentCont) {
		this.commentCont = commentCont;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentNo=" + commentNo + ", boardNo=" + boardNo + ", userId=" + userId + ", commentCont="
				+ commentCont + ", commentDate=" + commentDate + "]";
	}

}
