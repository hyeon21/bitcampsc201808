package com.bitcamp.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberRegController {

	// 의존 설정 : 회원가입 서비스  (수업에서는 생략)
	// 메일 발송을 위한 의존 설정 (MailSender 필요)
	
	@Autowired
	private SimpleRegistrationNotifier noti; // 서블릿 컨텍스트에 등록된 빈
	
	@RequestMapping("memberReg")
	public String memeberReg() {

		// 회원 가입 서비스.가입()

		// 가입 메일 발송처리
		noti.sendMail("runngun21@naver.com");
		noti.mailSendHtml("runngun21@naver.com");
		
		return "memberReg";
	}
}
