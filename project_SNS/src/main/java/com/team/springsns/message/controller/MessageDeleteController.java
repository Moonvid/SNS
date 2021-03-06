package com.team.springsns.message.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.model.MessageWriteInfo;
import com.team.springsns.message.service.MessageService;

@Controller
public class MessageDeleteController {

	@Autowired
	private MessageService service;

	@RequestMapping("/MessageDelete")
	public ModelAndView deleteMessage(MessageWriteInfo messageWriteInfo) throws UnsupportedEncodingException {
		ModelAndView modelAndView = new ModelAndView();
		int result = service.MessageDelete(messageWriteInfo);
		
		//삭제 버튼 눌러서 온 파라미터 인코딩
		if (result == 1) {
			String recvId = URLEncoder.encode(messageWriteInfo.getRecvid(), "utf-8");
			modelAndView.setViewName("redirect:/MessageTo/MessageTo?recvid=" + recvId);
		} else {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}
}