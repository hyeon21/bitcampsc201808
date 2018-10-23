package com.bitcamp.openprac2.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.model.MemberInfo;
import com.bitcamp.openprac2.service.MemberListService;

@Controller
public class MemberListController {

	@Autowired
	private MemberListService memberListService;
	
	@RequestMapping("/member/memberList")
	public ModelAndView getMemberList() throws SQLException {
		
		List<MemberInfo> members = memberListService.getMemberList();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("member/memberList");
		modelAndView.addObject("memberList", members);
		
		return modelAndView;
		
	}
	
	
}
