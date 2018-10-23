package com.bitcamp.openprac2.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.model.MemberInfo;
import com.bitcamp.openprac2.service.MemberRegService;
import com.bitcamp.openprac2.service.ServiceException;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {

	@Autowired
	private MemberRegService regService;

	@RequestMapping(method = RequestMethod.GET)
	public String getMemberRegForm() {
		return "member/memberRegForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView memberReg(MemberInfo memberInfo, HttpServletRequest request) throws SQLException, IllegalStateException, IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("member/regComplete");
		try {
			int resultCnt = regService.memberReg(memberInfo, request);
			
			System.out.println("Controller - 신규 회원의 인덱스 값 : " + memberInfo.getIdx());

			if (resultCnt < 1) {
				modelAndView.setViewName("member/regFail");
			}
		} catch (SQLException se) {
			modelAndView.setViewName("member/regFail");
			se.printStackTrace();
		}
		return modelAndView;
	}
}
