package com.team.springsns.search.vo;

public class DataVO {
	private int boardno;
	private String userno;
	private String boardcontent;
	private String boardphoto;
	private String hashtag;
	private String boardreportcnt;

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String idData) {
		this.userno = idData;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public String getBoardphoto() {
		return boardphoto;
	}

	public void setBoardphoto(String boardphoto) {
		this.boardphoto = boardphoto;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getBoardreportcnt() {
		return boardreportcnt;
	}

	public void setBoardreportcnt(String boardreportcnt) {
		this.boardreportcnt = boardreportcnt;
	}

	@Override
	public String toString() {
		return "DataDao [boardno=" + boardno + ", userno=" + userno + ", boardcontent=" + boardcontent + ", boardphoto="
				+ boardphoto + ", hashtag=" + hashtag + ", boardreportcnt=" + boardreportcnt + "]";
	}

}