package com.bitcamp.openprac2.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.openprac2.dao.JDBCTemplateMemberDao;
import com.bitcamp.openprac2.model.MemberInfo;
import com.bitcamp.openprac2.service.MemberEditService;

@Controller
@RequestMapping("/member/memberEdit")
public class MemberEditController {

	@Autowired
	private MemberEditService memberEditService;
	
	@Autowired
	private JDBCTemplateMemberDao memberDao;
	
	private MemberInfo memberInfo;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getMemberEditForm(@RequestParam("userId") String userId, Model model) throws SQLException {

		memberInfo = memberDao.select(userId);
				
		model.addAttribute("uId", memberInfo.getUserId());
		model.addAttribute("password", memberInfo.getPassword());
		model.addAttribute("userName", memberInfo.getUserName());
		model.addAttribute("userPhoto", memberInfo.getUserPhoto());

		return "member/memberEditForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String editMember(MemberInfo memberInfo, HttpServletRequest request) throws SQLException{

		memberEditService.editMember(memberInfo, request);

		return "redirect:/member/memberList";

	}
}
