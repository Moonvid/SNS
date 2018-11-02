package com.team.springsns.search.service;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.friend.model.FriendsListView;
import com.team.springsns.search.Interface.DataInterface;
import com.team.springsns.search.vo.DataVO;
import com.team.springsns.search.vo.SearchAndPageResultData;

@Service
public class SearchDataService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private DataInterface data;

	static int Page_Count_Number = 5;

	public SearchAndPageResultData getSearchData(String searchData) {
		data = sqlSessionTemplate.getMapper(DataInterface.class);
		List<DataVO> resultDataDao = new ArrayList<DataVO>();

		// 페이지갯수와 쿼리결과를 받기위한 VO
		SearchAndPageResultData searchAndPageResultData = new SearchAndPageResultData();
		FriendsListView friendsListView = new FriendsListView();
		FriendsListView resultfriendsListView = new FriendsListView();
		DataVO paramDataDao = new DataVO();

		// 문자열을 숫자 형식을 바꿔 주기 위해 NumberFormat사용
		NumberFormat nF = NumberFormat.getInstance();

		// parse의 위치가 맨 끝에있는지 확인하기 위해 파서포지션 사용
		ParsePosition pos = new ParsePosition(0);

		// Number형식으로 parse한것 String로 변환
		String IdData = "" + nF.parse(searchData, pos);

		boolean bool = searchData.contains("#");

		if (bool) {
			paramDataDao.setHashtag(searchData);
			resultDataDao = data.searchHashTagData(paramDataDao);

		} else if (!bool) {
			// 숫자인지 확인
			if (searchData.length() == pos.getIndex()) {
				paramDataDao.setUserno(IdData);
				friendsListView.setUserNo(Integer.parseInt(IdData));

				resultDataDao = data.searchIdData(paramDataDao);
				resultfriendsListView = data.searchUserId(friendsListView);
				searchAndPageResultData.setFriendsListView(resultfriendsListView);
			} else {
				// 숫자가 아니면 컨텐츠인걸로 확인
				paramDataDao.setBoardcontent(searchData);
				resultDataDao = data.searchContentData(paramDataDao);
			}
		}

//		페이징 처리 어케하냐!!!!!!!!!!!!!!!!!!!!!!!!
		int page = 1;
		int resultCnt = resultDataDao.size();
		int pagenum1 = resultCnt / Page_Count_Number;
		int pagenum2 = resultCnt % Page_Count_Number;
		int finalpage = pagenum1 + pagenum2;

		searchAndPageResultData.setPageData(finalpage);
		searchAndPageResultData.setQueryResult(resultDataDao);

		return searchAndPageResultData;
	}
}