package com.team.springsns.board.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class Board {

	private int boardNo;
	private int userNo;
	private String boardContent;
	private String boardPhoto;
	private MultipartFile boardPhotoFile;
	private String hashTag;
	private Timestamp boardDate;
	private boolean reportCheck;

	public Timestamp getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardPhoto() {
		return boardPhoto;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public MultipartFile getBoardPhotoFile() {
		return boardPhotoFile;
	}

	public void setBoardPhotoFile(MultipartFile boardPhotoFile) {
		this.boardPhotoFile = boardPhotoFile;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public boolean isReportCheck() {
		return reportCheck;
	}

	public void setReportCheck(boolean reportCheck) {
		this.reportCheck = reportCheck;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userNo=" + userNo + ", boardContent=" + boardContent + ", boardPhoto="
				+ boardPhoto + ", boardPhotoFile=" + boardPhotoFile + ", hashTag=" + hashTag + ", boardDate="
				+ boardDate + ", reportCheck=" + reportCheck + "]";
	}

}
