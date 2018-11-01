package com.team.springsns.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.springsns.model.MemberInfo;
import com.team.springsns.member.service.MemberProfileEditService;

@Controller
@RequestMapping("/team/profileEdit")
public class MemberProfileEditController {

	@Autowired
	private MemberProfileEditService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMemberEditForm(@RequestParam("userId") String userId, Model model) {

		ModelAndView modelAndView = new ModelAndView();
		MemberInfo memberInfo = service.getMemberInfo(userId);

		modelAndView.setViewName("team/profileEditForm");
		modelAndView.addObject("memberInfo", memberInfo);
		// model.addAttribute("memberInfo", memberInfo);

		// return "team/profileEditForm";
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView editMember(MemberInfo memberInfo, HttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {

		//service.editMember(memberInfo, request);

		// return "redirect:/team/team";
		String userId = (String) request.getParameter("userId");
		
		System.out.println("post 컨트롤러 들어옴: userId "+userId);
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("memberInfo", memberInfo);
		//modelAndView.setViewName("redirect:/board/boardList");

		service.editMember(memberInfo, request);
		session.setAttribute("loginInfo", memberInfo);
		modelAndView.addObject("userId", userId);
		
		modelAndView.setViewName("redirect:/board/boardList");
		return modelAndView;
		
	}

}
