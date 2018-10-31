package com.team.springsns.message.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.model.MessageWriteInfo;
import com.team.springsns.message.service.MessageService;

@Controller
@RequestMapping("/MessageFrom/MessageFrom")
public class MessageWriteController {

	@Autowired
	private MessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public String goMessageFrom() {
		String page = "MessageFrom/MessageFrom";
		return page;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView goMessageTo(MessageWriteInfo messageWriteInfo) {
		ModelAndView modelAndView = new ModelAndView();
		long time = System.currentTimeMillis();

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(date);

		String ctime = date.format(new Date(time));

		System.out.println(ctime);

		messageWriteInfo.setSendDate(ctime);
		
		service.goMessageTo(messageWriteInfo);
		modelAndView.setViewName("message");

		return modelAndView;

	}
}