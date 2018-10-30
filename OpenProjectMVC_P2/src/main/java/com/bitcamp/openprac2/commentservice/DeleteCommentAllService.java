package com.bitcamp.openprac2.commentservice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.CommentDaoInterface;

public class DeleteCommentAllService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public void deleteCommentAll(int messageId) {
		
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		commentDao.deleteCommentAll(messageId);
	}
}
