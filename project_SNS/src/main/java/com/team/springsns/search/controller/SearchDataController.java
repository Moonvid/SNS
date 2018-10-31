package com.team.springsns.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.search.vo.DataVO;
import com.team.springsns.search.service.SearchDataService;

@Controller
public class SearchDataController {

	@Autowired
	private SearchDataService service;

	@RequestMapping(value = "/check", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getSearchData(String searchData) {
		System.out.println("Controller 진입");

		ModelAndView modelAndView = new ModelAndView();
		List<DataVO> dataDao = new ArrayList<DataVO>();

		dataDao = service.getSearchData(searchData);
		modelAndView.addObject("dataVO", dataDao);
		modelAndView.setViewName("check");
		return modelAndView;
	}
}