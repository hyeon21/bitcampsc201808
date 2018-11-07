package com.bitcamp.openprac2.msgcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.openprac2.model.LikeMessageDTO;
import com.bitcamp.openprac2.msgservice.IsLikeMessageService;

@Controller
public class IsLikeMessageController {

	@Autowired
	public IsLikeMessageService isLikeMessageService;
	
	@RequestMapping("/book/isLike")
	@ResponseBody
	public List<LikeMessageDTO> isLikeMessage(@RequestParam("userIdx") int userIdx) {
		
		List<LikeMessageDTO> likeMe = new ArrayList<LikeMessageDTO>();
		
		likeMe = isLikeMessageService.isLikeMessage(userIdx);
		
		return likeMe;
	}
}
