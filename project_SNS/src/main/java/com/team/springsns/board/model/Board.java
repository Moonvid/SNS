package com.team.springsns.board.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Board {

	private int boardNo;
	private int userNo;
	private String userId;
	private String boardContent;
	private String boardPhoto;
	private MultipartFile boardPhotoFile;
	private String hashTag;
	private Timestamp boardDate;
	private int reportCheck;
	private int reportcnt;

	public int getBoardNo() {
		return boardNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getBoardPhoto() {
		return boardPhoto;
	}

	public MultipartFile getBoardPhotoFile() {
		return boardPhotoFile;
	}

	public String getHashTag() {
		return hashTag;
	}

	public Timestamp getBoardDate() {
		return boardDate;
	}

	public int getReportCheck() {
		return reportCheck;
	}

	public int getReportcnt() {
		return reportcnt;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public void setBoardPhotoFile(MultipartFile boardPhotoFile) {
		this.boardPhotoFile = boardPhotoFile;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}

	public void setReportCheck(int reportCheck) {
		this.reportCheck = reportCheck;
	}

	public void setReportcnt(int reportcnt) {
		this.reportcnt = reportcnt;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userNo=" + userNo + ", userId=" + userId + ", boardContent="
				+ boardContent + ", boardPhoto=" + boardPhoto + ", boardPhotoFile=" + boardPhotoFile + ", hashTag="
				+ hashTag + ", boardDate=" + boardDate + ", reportCheck=" + reportCheck + ", reportcnt=" + reportcnt
				+ "]";
	}

}
