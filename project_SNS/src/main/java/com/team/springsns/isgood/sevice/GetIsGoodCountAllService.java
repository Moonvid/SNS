package com.team.springsns.isgood.sevice;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.team.springsns.board.model.Board;
import com.team.springsns.isgood.dao.IsGoodDaoInterface;
import com.team.springsns.isgood.model.CountIsGoodDTO;

public class GetIsGoodCountAllService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private IsGoodDaoInterface isGoodDao;
	
	@Transactional
	public List<CountIsGoodDTO> getIsGoodCountAll(){
		
		isGoodDao = sqlSessionTemplate.getMapper(IsGoodDaoInterface.class);
		
		List<Board> boardAllList = new ArrayList<Board>();
		
		List<CountIsGoodDTO> isGoodCntAllList = new ArrayList<CountIsGoodDTO>();
		
		CountIsGoodDTO isGoodCntDTO = new CountIsGoodDTO();
		
		List<Integer> boardNoList = new ArrayList<Integer>();
		
		// 모든 보드 추출
		boardAllList = isGoodDao.getBoardAll();
			
		// 보드 사이즈만큼 졸린다
		for(int i=0; i<boardAllList.size(); i++) {
			// 보드 넘버만 추출한다
			boardNoList.add(boardAllList.get(i).getBoardNo());
			
		}
		
		// 보드 넘버 사이즈만큼 돌린다
		// 보드넘버별로 좋아요 개수를 카운트해서 isGoodCntDTO 객체에 저장해서 isGoodCntAllList에 add
		// 보드넘버로 카운트되는 좋아요가 없으면 null -> 넘버, 좋아요 0개로 객체저장
		for(int i=0; i<boardNoList.size(); i++) {
			isGoodCntDTO = isGoodDao.getCountIsGood(boardNoList.get(i));
			if(isGoodCntDTO==null) {
				isGoodCntDTO = new CountIsGoodDTO();
				isGoodCntDTO.setBoardNo(boardNoList.get(i));
				isGoodCntDTO.setIsGoodCnt(0);
			}
			isGoodCntAllList.add(isGoodCntDTO);
		}
		System.out.println("isGoodCntAllList : "+isGoodCntAllList);
		
		return isGoodCntAllList;
	}
	

}
