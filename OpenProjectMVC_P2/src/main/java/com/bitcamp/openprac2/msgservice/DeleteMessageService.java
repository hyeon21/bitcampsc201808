package com.bitcamp.openprac2.msgservice;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMessageDao;
import com.bitcamp.openprac2.service.ServiceException;

public class DeleteMessageService {

	@Autowired
	JDBCTemplateMessageDao messageDao;

	@Transactional
	public void deleteMessage(int messageId) throws ServiceException, SQLException {
			messageDao.delete(messageId);

	}

}
