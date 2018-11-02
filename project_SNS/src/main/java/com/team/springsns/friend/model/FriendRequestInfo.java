package com.team.springsns.friend.model;

public class FriendRequestInfo {
  
	private int requestNo;
	private int requestUserNo;
	private String requestUserName;
	private int responseUserNo;
	private String responseUserName;
	private boolean requestAccept;
	private boolean requestCancel;
	 
	public FriendRequestInfo() {
		
	}
	
	public FriendRequestInfo(int requestUserNo, int responseUserNo) {
		this.requestUserNo = requestUserNo;
		this.responseUserNo = responseUserNo;
	}
	
	public int getRequestNo() {
		return requestNo;
	}
	public void setRequestNo(int requestNo) {
		this.requestNo = requestNo;
	}
	public int getRequestUserNo() {
		return requestUserNo;
	}
	public void setRequestUserNo(int requestUserNo) {
		this.requestUserNo = requestUserNo;
	}
	public int getResponseUserNo() {
		return responseUserNo;
	}
	public void setResponseUserNo(int responseUserNo) {
		this.responseUserNo = responseUserNo;
	}
	public boolean isRequestAccept() {
		return requestAccept;
	}
	public void setRequestAccept(boolean requestAccept) {
		this.requestAccept = requestAccept;
	}
	public boolean isRequestCancel() {
		return requestCancel;
	}
	public void setRequestCancel(boolean requestCancel) {
		this.requestCancel = requestCancel;
	}

	public String getRequestUserName() {
		return requestUserName;
	}

	public void setRequestUserName(String requestUserName) {
		this.requestUserName = requestUserName;
	}

	public String getResponseUserName() {
		return responseUserName;
	}

	public void setResponseUserName(String responseUserName) {
		this.responseUserName = responseUserName;
	}

	@Override
	public String toString() {
		return "FriendRequestInfo [requestNo=" + requestNo + ", requestUserNo=" + requestUserNo + ", requestUserName="
				+ requestUserName + ", responseUserNo=" + responseUserNo + ", responseUserName=" + responseUserName
				+ ", requestAccept=" + requestAccept + ", requestCancel=" + requestCancel + "]";
	}
	
	
	
}
