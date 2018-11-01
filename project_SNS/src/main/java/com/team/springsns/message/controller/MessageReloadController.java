package com.team.springsns.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.springsns.message.service.MessageService;
import com.team.springsns.model.MessageWriteInfo;

@Controller
public class MessageReloadController {
	@Autowired
	private MessageService service;
	
	@RequestMapping("/ReloadMessage")
	@ResponseBody
	public MessageWriteInfo reloadMessage(MessageWriteInfo messageWriteInfo) {
		System.out.println("rerload:"+messageWriteInfo);
		MessageWriteInfo result=new MessageWriteInfo();
		result = service.getCntMessage(messageWriteInfo);
		System.out.println(result);
		return result;
		
	}
}
