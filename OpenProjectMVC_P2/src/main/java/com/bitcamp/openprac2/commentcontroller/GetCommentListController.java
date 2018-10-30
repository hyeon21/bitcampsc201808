package com.bitcamp.openprac2.commentcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.commentservice.GetCommentListService;
import com.bitcamp.openprac2.model.CommentDTO;

@Controller
public class GetCommentListController {

	@Autowired
	private GetCommentListService getCommentListService;
	
	@RequestMapping("/book/viewComment")
	@ResponseBody
	public List<CommentDTO> getCommentList(@RequestParam("msgId") int messageId) {
		
		System.out.println("messageId : " + messageId);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>();
		
		commentList = getCommentListService.getCommentList(messageId);
		
		System.out.println("commList : "+ commentList);
		
		return commentList;
	}
}
