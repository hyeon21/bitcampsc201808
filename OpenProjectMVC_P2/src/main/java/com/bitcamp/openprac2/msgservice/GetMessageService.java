package com.bitcamp.openprac2.msgservice;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMessageDao;
import com.bitcamp.openprac2.model.Message;

public class GetMessageService {
	
	@Autowired
	private JDBCTemplateMessageDao messageDao;

	@Transactional
	public Message getMessage(int messageId) throws SQLException {
		
		Message message = messageDao.select(messageId);
		
		return message;
	}
	
}
