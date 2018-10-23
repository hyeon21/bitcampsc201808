package com.bitcamp.openprac2.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.openprac2.service.MemberDeleteService;

@Controller
public class MemberDeleteController {
	@Autowired
	private MemberDeleteService memberDeleteService;
	
	@RequestMapping(value="/member/memberDelete", method=RequestMethod.GET)
	public String deleteMember(@RequestParam("userId") String userId) throws SQLException {

			memberDeleteService.deleteMember(userId);
		
		return "redirect:/member/memberList";
	}

}
