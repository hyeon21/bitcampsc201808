package com.bitcamp.openprac2.messagelikeservice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.MessageLikeDaoInterface;
import com.bitcamp.openprac2.model.MessageLike;

public class MessageLikeService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private MessageLikeDaoInterface messageLikeDao;
	
	@Transactional
	public int insertMessageLike(MessageLike messageLike) {
		int resultCnt=0;
		
		messageLikeDao = sqlSessionTemplate.getMapper(MessageLikeDaoInterface.class);
		
		if(!(messageLikeDao.selectMessageLike(messageLike)==null)) {
			messageLikeDao.deleteMessageLike(messageLike);
			System.out.println("좋아요 취소");
			
		}else {
		resultCnt = messageLikeDao.insertMessageLike(messageLike);
		System.out.println("좋아요!");
		}
		return resultCnt;
		
	}
}
