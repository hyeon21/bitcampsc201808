package com.bitcamp.openprac2.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	@Autowired
	private MemberLoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm() { // int는 null값이 들어 올 수 없다.
		return new ModelAndView("member/loginForm");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "password", required = false) String password, HttpSession session) throws SQLException {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/loginFail");

		if (userId != null && password != null) {
			
			if(loginService.login(userId, password, session)) {
				
				modelAndView.setViewName("member/"
						+ "loginComplete"); // 로그인 성공 시 index로 돌아가기
			}

		}

		modelAndView.addObject("userId", userId);
		modelAndView.addObject("password", password);

		return modelAndView;

	}
}
