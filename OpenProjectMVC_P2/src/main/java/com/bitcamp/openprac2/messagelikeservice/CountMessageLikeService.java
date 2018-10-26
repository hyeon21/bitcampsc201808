package com.bitcamp.openprac2.messagelikeservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.MessageLikeDaoInterface;
import com.bitcamp.openprac2.model.CountMessageLike;

public class CountMessageLikeService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private MessageLikeDaoInterface messageLikeDao;
	
	@Transactional
	public List<CountMessageLike> countMessageLike() {
		
		List<CountMessageLike> resultList = new ArrayList<CountMessageLike>();
		messageLikeDao = sqlSessionTemplate.getMapper(MessageLikeDaoInterface.class);
		
		resultList = messageLikeDao.countMessageLike();
		
		return resultList;
	}
}
