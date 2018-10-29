package com.bitcamp.openprac2.msgcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.msgservice.CountLikeMessageService;

@Controller
public class CountLikeMessageController {

	@Autowired
	public CountLikeMessageService countLikeMessageService;
	
	@RequestMapping("/book/likeCnt")
	@ResponseBody
	public int getCountLikeMessage(@RequestParam("messageId") int messageId) {
		System.out.println("likeCnt컨트롤러 진입!");
		
		int likeCnt = 0;
		
		likeCnt = countLikeMessageService.getCountLikeMessage(messageId);
		
		System.out.println("likeCnt 컨트롤러 likeCnt : "+likeCnt);
		
		/*String like= likeCnt+"";*/
		
		return likeCnt;
	}
}
