package com.team.springsns.search.service;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.springsns.search.Interface.DataInterface;
import com.team.springsns.search.vo.DataVO;

@Service
public class SearchDataService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private DataInterface data;

	public List<DataVO> getSearchData(String searchData) {
		System.out.println("Service 진입@@"+searchData);
		data = sqlSessionTemplate.getMapper(DataInterface.class);
		List<DataVO> resultDataDao = new ArrayList<DataVO>();

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
				resultDataDao = data.searchIdData(paramDataDao);

			} else {
				// 숫자가 아니면 컨텐츠인걸로 확인
				paramDataDao.setBoardcontent(searchData);
				resultDataDao = data.searchContentData(paramDataDao);
			}
		}
		return resultDataDao;
	}
}