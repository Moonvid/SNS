package com.team.springsns.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.comment.model.CommentDTO;
import com.team.springsns.comment.service.EditCommentService;
import com.team.springsns.comment.service.GetCommentService;

@Controller
@RequestMapping("/board/editComment")
public class EditCommentController {

	@Autowired
	private EditCommentService editCommentService;
	
	@Autowired
	private GetCommentService getCommentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getEditCommentForm(@RequestParam("commentNo") int commentNo) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		CommentDTO comment = new CommentDTO();
		
		comment = getCommentService.getComment(commentNo);
		
		System.out.println(comment.getCommentCont());
		
		modelAndView.addObject("comment", comment);
		modelAndView.setViewName("board/editCommentForm");
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView editComment(@RequestParam("commentCont") String commentCont, 
							  @RequestParam("commentNo") int commentNo,
							  @RequestParam("userId") String userId) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("커멘트 수정내용 - 커맨트넘버 : "+commentNo+" 내용: "+commentCont);
		
		editCommentService.editComment(commentCont, commentNo);

		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList");
		
		return modelAndView;
	}
	
}
