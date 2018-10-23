package com.bitcamp.openprac2.msgservice;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMessageDao;
import com.bitcamp.openprac2.model.Message;
import com.bitcamp.openprac2.service.ServiceException;

public class WriteMessageService {
	
	@Autowired
	JDBCTemplateMessageDao messageDao;
	
	@Transactional
	public void write(Message message) throws ServiceException, SQLException {
		
			messageDao.insert(message);
			
	}

}
