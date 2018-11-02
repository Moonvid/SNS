package com.team.springsns.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.search.service.SearchDataService;
import com.team.springsns.search.vo.SearchAndPageResultData;

@Controller
public class SearchDataController {
	
	@Autowired
	private SearchDataService service;

	@RequestMapping(value = "/check", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getSearchData(String search) {
		ModelAndView modelAndView = new ModelAndView();
		SearchAndPageResultData dataDao = new SearchAndPageResultData();
		
		dataDao = service.getSearchData(search);
		
		modelAndView.addObject("dataVO", dataDao.getQueryResult());
		modelAndView.addObject("userVO", dataDao.getFriendsListView());
		modelAndView.addObject("search",search);
		modelAndView.setViewName("check");
		
		return modelAndView;
	}
}