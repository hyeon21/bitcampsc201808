package com.bitcamp.openprac2.msgcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.model.LikeMessageDTO;
import com.bitcamp.openprac2.msgservice.LikeMessageService;

@Controller
public class LikeMessageController {

	@Autowired
	private LikeMessageService likeMessageService;
	
	@RequestMapping("/book/likeMessage")
	public ModelAndView messageLike(@RequestParam("messageId") int messageId,
									@RequestParam("userIdx") int userIdx) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		LikeMessageDTO likeMessage = new LikeMessageDTO();
		likeMessage.setMessageId(messageId);
		likeMessage.setUserIdx(userIdx);
		
		likeMessageService.insertLikeMessage(likeMessage);
		
		modelAndView.setViewName("redirect:/book/bookList");
		
		return modelAndView;
	}
}
