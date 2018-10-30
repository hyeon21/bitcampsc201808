package com.bitcamp.openprac2.commentservice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.CommentDaoInterface;
import com.bitcamp.openprac2.model.CommentDTO;

public class EditCommentService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public void editComment(String comment, int commentNo) {
		
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		System.out.println("커맨트 수정 서비스 - " + comment +" : " + "커맨트넘버 : " +commentNo);
		
		commentDao.updateComment(comment, commentNo);
	}
}
