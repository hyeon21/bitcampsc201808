package com.bitcamp.openprac2.commentcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.openprac2.commentservice.EditCommentService;
import com.bitcamp.openprac2.model.CommentDTO;

@Controller
@RequestMapping("/book/editComment")
public class EditCommentController {

	@Autowired
	private EditCommentService editCommentService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getEditCommentForm() {
		
		return "book/editCommentForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String editComment(@RequestParam("comment") String comment, int commentNo) {
		
		/*int commentNo = commentDTO.getCommentNo();
		String comment = commentDTO.getComment();
		*/
		System.out.println("커멘트 수정내용 - 커맨트넘버 : "+commentNo+" 내용: "+comment);
		
		editCommentService.editComment(comment, commentNo);
		
		return "redirect:/book/bookListAjax";
	}
	
}
