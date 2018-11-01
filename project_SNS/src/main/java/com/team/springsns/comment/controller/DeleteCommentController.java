package com.team.springsns.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.springsns.comment.service.DeleteCommentService;

@Controller
public class DeleteCommentController  {
	
	@Autowired
	private DeleteCommentService deleteCommentService;

	@RequestMapping("/board/deleteComment")
	public String deleteComment(@RequestParam("commentNo") int commentNo) {
		
		deleteCommentService.deleteComment(commentNo);
		
		return "redirect:/board/boardList";
	}
}
