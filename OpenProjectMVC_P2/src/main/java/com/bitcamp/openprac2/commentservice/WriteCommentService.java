package com.bitcamp.openprac2.commentservice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.CommentDaoInterface;
import com.bitcamp.openprac2.model.CommentDTO;

public class WriteCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public void writeComment(CommentDTO commentDTO) {
		
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		commentDao.insertComment(commentDTO);
	}
}
