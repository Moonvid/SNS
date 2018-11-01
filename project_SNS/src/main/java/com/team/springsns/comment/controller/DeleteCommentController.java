package com.team.springsns.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.comment.service.DeleteCommentService;

@Controller
public class DeleteCommentController  {
	
	@Autowired
	private DeleteCommentService deleteCommentService;

	@RequestMapping("/board/deleteComment")
	public ModelAndView deleteComment(@RequestParam("commentNo") int commentNo,
			@RequestParam(value = "userId", required = false) String userId) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		deleteCommentService.deleteComment(commentNo);
		
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList");
		
		return modelAndView;
	}
}
