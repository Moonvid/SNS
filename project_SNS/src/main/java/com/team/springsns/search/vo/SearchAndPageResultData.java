package com.team.springsns.search.vo;

import java.util.List;

import com.team.springsns.friend.model.FriendsListView;

public class SearchAndPageResultData {
	private int pageData;
	private List<DataVO> queryResult;
	private int userno;
	private FriendsListView friendsListView;

	public int getPageData() {
		return pageData;
	}

	public void setPageData(int pageData) {
		this.pageData = pageData;
	}

	public List<DataVO> getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(List<DataVO> queryResult) {
		this.queryResult = queryResult;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public FriendsListView getFriendsListView() {
		return friendsListView;
	}

	public void setFriendsListView(FriendsListView friendsListView) {
		this.friendsListView = friendsListView;
	}

	@Override
	public String toString() {
		return "SearchAndPageResultData [pageData=" + pageData + ", queryResult=" + queryResult + ", userno=" + userno
				+ ", friendsListView=" + friendsListView + "]";
	}

}
