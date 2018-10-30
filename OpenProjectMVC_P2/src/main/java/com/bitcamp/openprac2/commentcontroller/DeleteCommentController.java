package com.bitcamp.openprac2.commentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.openprac2.commentservice.DeleteCommentService;

@Controller
public class DeleteCommentController  {
	
	@Autowired
	private DeleteCommentService deleteCommentService;

	@RequestMapping("/book/deleteComment")
	public String deleteComment(@RequestParam("commentNo") int commentNo) {
		
		deleteCommentService.deleteComment(commentNo);
		
		return "redirect:/book/bookListAjax";
	}
}
