package com.bitcamp.openprac2.commentservice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.CommentDaoInterface;

public class DeleteCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public void deleteComment(int commentNo) {
		
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		commentDao.deleteComment(commentNo);
		
	}
	
	
}
