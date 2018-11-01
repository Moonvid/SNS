package com.team.springsns.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.springsns.comment.model.CommentDTO;
import com.team.springsns.comment.service.WriteCommentService;

@Controller
@RequestMapping("/board/comment")
public class WriteCommentController {
	
	@Autowired
	private WriteCommentService writeCommentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCommentForm() {
		return "board/commentForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String writeComment(CommentDTO commentDTO) {
		writeCommentService.writeComment(commentDTO);
		return "redirect:/board/boardList";
	}

}
