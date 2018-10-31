package com.team.springsns.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.model.MessageWriteInfo;
import com.team.springsns.message.service.MessageService;

@Controller
@RequestMapping("/ReadMessage")
public class ReadMessageController {
	@Autowired
	private MessageService service;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int readMessage(String messageno) {
		MessageWriteInfo messageWriteInfo = new MessageWriteInfo();
		messageWriteInfo.setMessageno(messageno);
		return service.changeCheckMessage(messageWriteInfo);
	}
}