package com.bitcamp.openprac2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMypageController {

	@RequestMapping("/member/myPage")
	public String getMyPage() {
		return "member/myPage";
	}
	
}
