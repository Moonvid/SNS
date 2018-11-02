package com.team.springsns.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView writeComment(@RequestParam(value = "userId", required = false) String userId,
								CommentDTO commentDTO) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("userId", userId);
		modelAndView.setViewName("redirect:/board/boardList");
		//언니진짜바봉..ㅋㅋㅋㅋ
		writeCommentService.writeComment(commentDTO);
		
		return modelAndView;
	}

}
