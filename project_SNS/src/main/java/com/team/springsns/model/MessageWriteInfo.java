package com.team.springsns.model;

public class MessageWriteInfo {
	private int count;
	private String messageno;
	private String sendid;
	private String recvid;
	private String messagecont;
	private String senddate;
	private String hashTag;
	private boolean checkmessage = false;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessageno() {
		return messageno;
	}

	public void setMessageno(String messageno) {
		this.messageno = messageno;
	}

	public String getSendid() {
		return sendid;
	}

	public void setSendid(String sendid) {
		this.sendid = sendid;
	}

	public String getRecvid() {
		return recvid;
	}

	public void setRecvid(String recvid) {
		this.recvid = recvid;
	}

	public String getMessagecont() {
		return messagecont;
	}

	public void setMessagecont(String messagecont) {
		this.messagecont = messagecont;
	}

	public String getSenddate() {
		return senddate;
	}

	public void setSenddate(String senddate) {
		this.senddate = senddate;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public boolean isCheckmessage() {
		return checkmessage;
	}

	public void setCheckmessage(boolean checkmessage) {
		this.checkmessage = checkmessage;
	}

	@Override
	public String toString() {
		return "MessageWriteInfo [count=" + count + ", messageno=" + messageno + ", sendid=" + sendid + ", recvid="
				+ recvid + ", messagecont=" + messagecont + ", senddate=" + senddate + ", hashTag=" + hashTag
				+ ", checkmessage=" + checkmessage + "]";
	}

}