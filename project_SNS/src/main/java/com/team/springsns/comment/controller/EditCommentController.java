package com.team.springsns.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.springsns.comment.service.EditCommentService;

@Controller
@RequestMapping("/board/editComment")
public class EditCommentController {

	@Autowired
	private EditCommentService editCommentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getEditCommentForm() {
		
		return "board/editCommentForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String editComment(@RequestParam("commentCont") String commentCont, int commentNo) {
		
		System.out.println("커멘트 수정내용 - 커맨트넘버 : "+commentNo+" 내용: "+commentCont);
		
		editCommentService.editComment(commentCont, commentNo);
		
		return "redirect:/board/boardList";
	}
	
}
