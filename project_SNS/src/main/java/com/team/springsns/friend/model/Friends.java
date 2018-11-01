package com.team.springsns.friend.model;

public class Friends {
 
	int userNo;
	int friendNo;
	
	public Friends() {
		
	}
	 
	public Friends(int userNo, int friendNo) {
		super();
		this.userNo = userNo;
		this.friendNo = friendNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(int friendNo) {
		this.friendNo = friendNo;
	}
	@Override
	public String toString() {
		return "Friends [userNo=" + userNo + ", friendNo=" + friendNo + "]";
	}

	
	
}