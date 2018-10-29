package com.bitcamp.openprac2.msgservice;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.JDBCTemplateMessageDao;
import com.bitcamp.openprac2.dao.LikeMessageDaoInterface;
import com.bitcamp.openprac2.service.ServiceException;

public class DeleteMessageService {

	@Autowired
	JDBCTemplateMessageDao messageDao;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LikeMessageDaoInterface likeMessageDao;
	
	@Transactional
	public void deleteMessage(int messageId) throws ServiceException, SQLException {
		
		likeMessageDao = sqlSessionTemplate.getMapper(LikeMessageDaoInterface.class);
		
		messageDao.delete(messageId);
			
		likeMessageDao.deleteLikeMessageAll(messageId);
	}

}
