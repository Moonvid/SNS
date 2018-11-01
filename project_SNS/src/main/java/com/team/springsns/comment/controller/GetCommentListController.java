package com.team.springsns.comment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.comment.model.CommentDTO;
import com.team.springsns.comment.service.GetCommentListService;

@Controller
public class GetCommentListController {

	@Autowired
	private GetCommentListService getCommentListService;
	
	@RequestMapping("/board/viewComment")
	@ResponseBody
	public List<CommentDTO> getCommentList(@RequestParam("bNo") int boardNo) {
		
		System.out.println("boardNo : " + boardNo);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		
		commentList = getCommentListService.getCommentList(boardNo);
		
		System.out.println("commList : "+ commentList);
		
		return commentList;
	}
}
