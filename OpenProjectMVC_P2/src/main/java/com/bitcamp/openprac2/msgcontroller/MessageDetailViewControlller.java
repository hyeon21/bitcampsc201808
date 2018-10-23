package com.bitcamp.openprac2.msgcontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.openprac2.model.Message;
import com.bitcamp.openprac2.msgservice.GetMessageService;

@Controller
public class MessageDetailViewControlller {
	
	@Autowired
	private GetMessageService service;

	@RequestMapping("/book/messageDetailView/{id}")
	public String getView(@PathVariable("id") int id,
			Model model) throws SQLException {
		
		Message message = service.getMessage(id); 
		model.addAttribute("message", message);
		
		
		return "book/messageDetailView";
		
	}
	
}
