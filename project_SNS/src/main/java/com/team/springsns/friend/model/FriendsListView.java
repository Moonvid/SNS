package com.team.springsns.friend.model;

import org.springframework.web.multipart.MultipartFile;

public class FriendsListView {
	 
	private int userNo;
	private String userId;
	private String userName;
	private String profilePhoto;
	private String userIntro;
	private boolean userBlock;
	private boolean manager;
	private MultipartFile photoFile;
	private int friendNo;

	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public boolean isUserBlock() {
		return userBlock;
	}
	public void setUserBlock(boolean userBlock) {
		this.userBlock = userBlock;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
	public MultipartFile getPhotoFile() {
		return photoFile;
	}
	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}
	public int getFriendNo() {
		return friendNo;
	}
	public void setfriendNo(int friendNo) {
		this.friendNo = friendNo;
	}
	@Override
	public String toString() {
		return "FriendsListView [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", profilePhoto="
				+ profilePhoto + ", userIntro=" + userIntro + ", userBlock=" + userBlock + ", manager=" + manager
				+ ", photoFile=" + photoFile + ", friendNo=" + friendNo + "]";
	}

	
	
	
	
	

	
	
}