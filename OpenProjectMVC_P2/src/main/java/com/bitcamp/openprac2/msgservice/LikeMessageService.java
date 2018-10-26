package com.bitcamp.openprac2.msgservice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.LikeMessageDaoInterface;
import com.bitcamp.openprac2.model.LikeMessageDTO;

public class LikeMessageService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private LikeMessageDaoInterface likeMessageDao;
	
	@Transactional
	public int insertLikeMessage(LikeMessageDTO likeMessage) {
		int resultCnt=0;
		
		likeMessageDao = sqlSessionTemplate.getMapper(LikeMessageDaoInterface.class);
		
		if(!(likeMessageDao.selectLikeMessage(likeMessage)==null)) {
			likeMessageDao.deleteLikeMessage(likeMessage);
			System.out.println("좋아요 취소");
			
		}else {
		resultCnt = likeMessageDao.insertLikeMessage(likeMessage);
		System.out.println("좋아요!");
		}
		return resultCnt;
		
	}
}
