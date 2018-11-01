package com.team.springsns.isgood.model;

public class CountIsGoodDTO {

	private int boardNo;
	private int isGoodCnt;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getIsGoodCnt() {
		return isGoodCnt;
	}

	public void setIsGoodCnt(int isGoodCnt) {
		this.isGoodCnt = isGoodCnt;
	}

	@Override
	public String toString() {
		return "CountIsGoodDTO [boardNo=" + boardNo + ", isGoodCnt=" + isGoodCnt + "]";
	}

}
