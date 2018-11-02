package com.team.springsns.search.Interface;

import java.util.List;

import com.team.springsns.friend.model.FriendsListView;
import com.team.springsns.search.vo.DataVO;

public interface DataInterface {
	public List<DataVO> searchHashTagData(DataVO dataDao);
	public List<DataVO> searchContentData(DataVO dataDao);
	public List<DataVO> searchIdData(DataVO dataDao);
	public FriendsListView searchUserId(FriendsListView friendsListView);
}