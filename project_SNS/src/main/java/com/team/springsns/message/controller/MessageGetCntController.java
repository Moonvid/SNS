package com.team.springsns.message.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.message.service.MessageService;
import com.team.springsns.model.MemberInfo;
import com.team.springsns.model.MessageWriteInfo;

@Controller
@RequestMapping("/MessageTo/WhoRecv")
public class MessageGetCntController {

	@Autowired
	private MessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView goWhoRecv(MessageWriteInfo messageWriteInfo,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("2222"+messageWriteInfo);
		String recvid = (String)(((MemberInfo)session.getAttribute("loginInfo")).getUserId());
		
		messageWriteInfo.setRecvid(recvid);
		System.out.println("3333"+messageWriteInfo);
		MessageWriteInfo resultInfo = service.getCntMessage(messageWriteInfo);
		
		modelAndView.addObject("resultInfo", resultInfo);
		modelAndView.setViewName("MessageTo/MessageTo");
		
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