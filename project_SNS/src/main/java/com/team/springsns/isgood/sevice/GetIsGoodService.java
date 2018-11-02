package com.team.springsns.isgood.sevice;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.isgood.dao.IsGoodDaoInterface;
import com.team.springsns.isgood.model.IsGoodDTO;

@Service
public class GetIsGoodService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private IsGoodDaoInterface isGoodDao;
	
	@Transactional
	public List<IsGoodDTO> getIsGoods(int userNo) {
		isGoodDao = sqlSessionTemplate.getMapper(IsGoodDaoInterface.class);
		
		List<IsGoodDTO> isGoods = new ArrayList<IsGoodDTO>();
		
		isGoods = isGoodDao.getIsGoods(userNo);
		
		IsGoodDTO isGood = new IsGoodDTO();
		isGood.setBoardNo(-1);
		isGood.setUserNo(userNo);
		
		if(isGoods.isEmpty()) {
			isGoods.add(isGood);
		}
		return isGoods;
	}
}
