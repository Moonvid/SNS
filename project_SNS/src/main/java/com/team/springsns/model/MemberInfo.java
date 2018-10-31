package com.team.springsns.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {
	
	private int userNo;
	private String userId;
	private String userName;
	private String userPassword;
	private String userProfilePhoto;
	private String userIntro;
	private boolean userBlock; 
	private boolean manager;
	private MultipartFile photoFile; // 폼을 통해 받는 파일 이름
	
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
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserProfilePhoto() {
		return userProfilePhoto;
	}
	public void setUserProfilePhoto(String userProfilePhoto) {
		this.userProfilePhoto = userProfilePhoto;
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
	
	@Override
	public String toString() {
		return "MemberInfo [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userPassword="
				+ userPassword + ", userProfilePhoto=" + userProfilePhoto + ", userIntro=" + userIntro + ", userBlock="
				+ userBlock + ", manager=" + manager + ", photoFile=" + photoFile + "]";
	}
	
}
