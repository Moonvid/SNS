package com.team.springsns.model;

public class MessageWriteInfo {
	private int count;
	private String messageNum;
	private String sendId;
	private String recvId;
	private String messageCont;
	private String sendDate;
	private String hashTag;
	private boolean checkMessage = false;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(String messageNum) {
		this.messageNum = messageNum;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getRecvId() {
		return recvId;
	}

	public void setRecvId(String recvId) {
		this.recvId = recvId;
	}

	public String getMessageCont() {
		return messageCont;
	}

	public void setMessageCont(String messageCont) {
		this.messageCont = messageCont;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public boolean isCheckMessage() {
		return checkMessage;
	}

	public void setCheckMessage(boolean checkMessage) {
		this.checkMessage = checkMessage;
	}

	@Override
	public String toString() {
		return "MessageWriteInfo [count=" + count + ", MessageNum=" + messageNum + ", sendId=" + sendId + ", recvId="
				+ recvId + ", messageCont=" + messageCont + ", sendDate=" + sendDate + ", hashTag=" + hashTag
				+ ", checkMessage=" + checkMessage + "]";
	}

}