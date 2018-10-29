package com.bitcamp.openprac2.msgcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.openprac2.model.LikeMessageDTO;
import com.bitcamp.openprac2.msgservice.CountLikeMessageService;
import com.bitcamp.openprac2.msgservice.LikeMessageService;

@Controller
public class LikeMessageController {

	@Autowired
	private LikeMessageService likeMessageService;
	
	@Autowired
	private CountLikeMessageService countLikeMessageService;
	
	@RequestMapping("/book/likeMessage")
	@ResponseBody
	public String likeMessage(@RequestParam("messageId") int messageId,
									@RequestParam("userIdx") int userIdx) {
		
		int likeCnt=0;
		
		LikeMessageDTO likeMessage = new LikeMessageDTO();
	
		likeMessage.setMessageId(messageId);
		likeMessage.setUserIdx(userIdx);
		
		System.out.println("라이크메세지컨트롤러 - 누가 뭘 눌렀나? : "+likeMessage);
		
		likeMessageService.insertLikeMessage(likeMessage);
		System.out.println("좋아요 찍고 - message_like 테이블에 insert");
		likeCnt = countLikeMessageService.getCountLikeMessage(messageId); 
		
		// modelAndView.setViewName("redirect:/book/bookList");
		
		System.out.println("라이크메세지컨트롤러 - likeCnt : "+likeCnt);
	
		String like = likeCnt+"";
		/*System.out.println("like: "+like);*/
		
		return like;
	}
}
