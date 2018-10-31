package com.team.springsns.message.controller;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.model.MessageWriteInfo;
import com.team.springsns.message.service.MessageService;

@Controller
public class MessageGetMessageController {

	@Autowired
	private MessageService service;

	@RequestMapping(value = "/MessageTo/MessageTo")
	public ModelAndView getMessage(@RequestParam("recvid") String recvId, MessageWriteInfo messageWriteInfo) {
		ModelAndView modelAndView = new ModelAndView();
		if (recvId != null) {
			messageWriteInfo.setRecvid(recvId);
		}

		List<MessageWriteInfo> list;
		list = service.getMessage(messageWriteInfo);

		modelAndView.addObject("messageInfo", list);
		modelAndView.setViewName("MessageTo/MessageTo");
		return modelAndView;
	}
}	