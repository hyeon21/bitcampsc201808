package com.bitcamp.openprac2.commentservice;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.CommentDaoInterface;
import com.bitcamp.openprac2.model.CommentDTO;

public class GetCommentListService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private CommentDaoInterface commentDao;
	
	@Transactional
	public List<CommentDTO> getCommentList(int messageId){
	
		commentDao = sqlSessionTemplate.getMapper(CommentDaoInterface.class);
		
		List<CommentDTO> commentList = new ArrayList<CommentDTO>(); 
				
		commentList = commentDao.selectCommentList(messageId);
		
		return commentList;
	}
	
}
