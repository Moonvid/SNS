package com.team.springsns.search.vo;

import java.util.List;

public class SearchAndPageResultData {
	private int pageData;
	private List<DataVO> queryResult;

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

	@Override
	public String toString() {
		return "SearchAndPageResultData [pageData=" + pageData + ", queryResult=" + queryResult + "]";
	}

}
