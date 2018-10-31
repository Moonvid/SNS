package com.team.springsns.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.message.service.MessageService;
import com.team.springsns.model.MessageWriteInfo;

@Controller
@RequestMapping("/MessageTo/WhoRecv")
public class MessageGetCntController {

	@Autowired
	private MessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView goWhoRecv(MessageWriteInfo messageWriteInfo) {
		System.out.println(messageWriteInfo);
		ModelAndView modelAndView = new ModelAndView();
		MessageWriteInfo resultInfo = service.getCntMessage(messageWriteInfo);
		
		modelAndView.addObject("messageInfo", resultInfo);
		modelAndView.setViewName("MessageTo/MessageCnt");
		
		return modelAndView;
	}

/*	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView getCntMessage(MessageWriteInfo messageWriteInfo) {
		ModelAndView modelAndView = new ModelAndView();

		MessageWriteInfo resultInfo = service.getCntMessage(messageWriteInfo);

		modelAndView.addObject("messageInfo", resultInfo);
		modelAndView.setViewName("/MessageTo/MessageCnt");
		return modelAndView;
	}*/
}