package com.bitcamp.openprac2.messagelikeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.messagelikeservice.MessageLikeService;
import com.bitcamp.openprac2.model.MessageLike;

@Controller
public class messageLikeController {

	@Autowired
	private MessageLikeService messageLikeService;
	
	@RequestMapping("/book/messageLike")
	public ModelAndView messageLike(@RequestParam("messageId") int messageId,
									@RequestParam("userIdx") int userIdx) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		MessageLike messageLike = new MessageLike();
		messageLike.setMessageId(messageId);
		messageLike.setUserIdx(userIdx);
		
		messageLikeService.insertMessageLike(messageLike);
		
		modelAndView.setViewName("redirect:/book/bookList");
		
		return modelAndView;
	}
}
