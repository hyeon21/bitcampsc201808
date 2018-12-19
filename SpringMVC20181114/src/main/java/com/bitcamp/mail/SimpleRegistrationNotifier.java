package com.bitcamp.mail;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

//서비스역할
public class SimpleRegistrationNotifier {

	@Autowired
	private JavaMailSender mailSender; // 빈에 등록된거 자동의존설정

	/*public void sendMail(Member member) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[Simple] 회원 가입을 축하합니다.");
		message.setFrom("isincorp@gmail.com");
		message.setText("회원 가입을 환영합니다.");
		message.setTo(member.getMemberid());
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			ex.printStackTrace();
		}
	}*/

	public void sendMail(String memberemail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("[Simple] 회원 가입 안내");
		message.setFrom("hyeonbit@gmail.com"); // 여기에 뭐라고 쓰던 폼에 등록된 이메일주소로 보내진다
		message.setText("회원 가입을 환영합니다.");
		message.setTo(memberemail);
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			ex.printStackTrace();
		}

	}
	
	
	public void mailSendHtml(String email) {
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			message.setSubject("[안내] 회원 가입을 축하합니다", "utf-8");
			String htmlStr = "<h2>안녕하세요!<h2> 회원님. <br>"
						   + "회원가입을 진심으로 감사드립니다. <br>"
						   + "<a href=\"http://naver.com\">사이트 가기</a>";
			message.setText(htmlStr, "utf-8", "html");
			// setFrom은 패스... 구글메일이라 빈등록한걸로 들어감
			message.addRecipient(RecipientType.TO, new InternetAddress(email));
			
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}

}
