package com.bitcamp.openprac2.commentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.openprac2.commentservice.WriteCommentService;
import com.bitcamp.openprac2.model.CommentDTO;

@Controller
@RequestMapping("/book/comment")
public class WriteCommentController {
	
	@Autowired
	private WriteCommentService writeCommentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCommentForm() {
		return "book/commentForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String writeComment(CommentDTO commentDTO) {
		writeCommentService.writeComment(commentDTO);
		return "redirect:/book/bookListAjax";
	}

}
