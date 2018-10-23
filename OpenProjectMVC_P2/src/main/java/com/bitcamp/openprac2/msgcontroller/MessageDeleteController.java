package com.bitcamp.openprac2.msgcontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.openprac2.msgservice.DeleteMessageService;
import com.bitcamp.openprac2.service.ServiceException;

@Controller
@RequestMapping("/book/deleteMessage")
public class MessageDeleteController {
	
	@Autowired
	private DeleteMessageService deleteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String deleteMessage(@RequestParam("id") int messageId) throws SQLException {
		
		String viewName = "redirect:/book/bookList";
		
		try {
			deleteService.deleteMessage(messageId);
			
		} catch (ServiceException e) {
			viewName = "book/error";
		}
		
		return viewName;
	}
}
