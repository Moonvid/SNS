package com.team.springsns.message.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/MessageFrom/MessageFrom")
public class MessageWriteController {

	@Autowired
	private MessageService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView goMessageFrom(String recvid,String sendid) {
		ModelAndView modelAndView = new ModelAndView();
		MessageWriteInfo messageWriteInfo = new MessageWriteInfo();
		messageWriteInfo.setRecvid(recvid);
		messageWriteInfo.setSendid(sendid);
		modelAndView.setViewName("MessageFrom/MessageFrom");
		modelAndView.addObject("messageWriteInfo", messageWriteInfo);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView goMessageTo(MessageWriteInfo messageWriteInfo, HttpSession session,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(messageWriteInfo);
		long time = System.currentTimeMillis();

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(date);

		String ctime = date.format(new Date(time));

		System.out.println(ctime);

		messageWriteInfo.setSenddate(ctime);
//		세션의 id 값 받아온다
		String userid = (String)((MemberInfo) session.getAttribute("loginInfo")).getUserId();
		
		service.goMessageTo(messageWriteInfo);
		
		modelAndView.setViewName("redirect:/board/boardList?userId="+userid);

		return modelAndView;

	}
}