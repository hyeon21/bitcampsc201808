package com.bitcamp.openprac2.msgcontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.openprac2.model.Message;
import com.bitcamp.openprac2.msgservice.WriteMessageService;
import com.bitcamp.openprac2.service.ServiceException;

@Controller
@RequestMapping("/book/writeMessage")
public class MessageWriteController {

	@Autowired
	private WriteMessageService writeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getWriteMessage() {
		
		return "book/writeMessageForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String writeMessage(Message message) throws ServiceException, SQLException{
		
		writeService.write(message);
		
		// 리다이렉트 뷰... 뷰 이름에 redirect: 접두어를 붙이면 지정한 페이지로 리다이렉트.
		return "redirect:/book/bookListAjax";
	}
	
	
}
