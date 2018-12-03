package com.team.springsns.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.team.springsns.board.model.Board;

public interface BoardDao {
	
	//board 추가
	public int insert(Board board);
	//boardno에 대한 board 선택
	public Board select(int boardno);
	//board count
	public int selectCount(String userId);
	//리스트(페이징)
	public List<Board> selectList(@Param("userId") String userId, @Param("firstRow") int firstRow, @Param("endRow") int endRow );
	//삭제
	public int delete(int boardno);
	//수정
	public int edit(Board board);
	
	/*public int reportCnt(int boardNo); // 신고건수*/	
	public int report(int boardNo); // 신고받은 게시글 바꿔주기
	public int reportUp(@Param("boardNo") int boardNo, @Param("userId") String userId); // 추가
	public int reportcntPlus(@Param("boardNo") int boardNo);
	public int reportcntCnt(int boardNo);
	public int reportcntUp(int boardNo);
	public int reportBoolean(int boardNo);
	public List<Board> reportCom(@Param("userId") String userId);
	
}
