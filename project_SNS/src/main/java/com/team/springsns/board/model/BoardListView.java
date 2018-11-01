package com.team.springsns.board.model;

import java.util.List;

public class BoardListView {
	private int boardTotalCount; // 전체게시글수
	private int currentPageNumber; // 페이지넘버
	private List<Board> boardList; // 게시글리스트
	private int pageTotalCount; // 페이지전체갯수
	private int boardCountPerPage; // 페이지당 게시글 수?
	private int firstRow;
	private int endRow;

	public BoardListView(List<Board> boardList, int boardTotalCount, int currentPageNumber, int boardCountPerPage,
			int firstRow, int endRow) {
		
		this.boardList = boardList;
		this.boardTotalCount = boardTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.boardCountPerPage = boardCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		
		calculatePageTotalCount();
	}
	
	private void calculatePageTotalCount() {
		if(boardTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = boardTotalCount / boardCountPerPage;
			if(boardTotalCount % boardCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}
	
	public boolean isEmpty() {
		return boardTotalCount == 0;
	}

	public int getBoardTotalCount() {
		return boardTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getBoardCountPerPage() {
		return boardCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
	

}
