package com.team.springsns.isgood.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.isgood.model.IsGoodDTO;
import com.team.springsns.isgood.sevice.GetIsGoodService;

@Controller
public class GetIsGoodController {

	@Autowired
	public GetIsGoodService getIsGoodService;
	
	@RequestMapping("/board/isGood")
	@ResponseBody
	public List<IsGoodDTO> isLikeMessage(@RequestParam("userNo") int userNo) {
		
		List<IsGoodDTO> likeMe = new ArrayList<IsGoodDTO>();
		
		likeMe = getIsGoodService.getIsGoods(userNo);
		
		return likeMe;
	}
}
