package com.team.springsns.isgood.dao;

import java.util.List;

import com.team.springsns.board.model.Board;
import com.team.springsns.isgood.model.CountIsGoodDTO;
import com.team.springsns.isgood.model.IsGoodDTO;

public interface IsGoodDaoInterface {

	public IsGoodDTO selectIsGood(IsGoodDTO isGoodDTO);
	public void insertIsGood(IsGoodDTO isGoodDTO);
	public int deleteIsGood(IsGoodDTO isGoodDTO);
	public CountIsGoodDTO getCountIsGood(int boardNo);
	public List<Board> getBoardAll();
	public void deleteIsGoodAll(int boardNo);
}
