package com.bitcamp.openprac2.msgservice;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.LikeMessageDaoInterface;
import com.bitcamp.openprac2.model.CountLikeMessageDTO;

public class CountLikeMessageService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LikeMessageDaoInterface likeMessageDao;
	
	@Transactional
	public int getCountLikeMessage(int messageId) {
		
		CountLikeMessageDTO likeCnt;
		
		likeMessageDao = sqlSessionTemplate.getMapper(LikeMessageDaoInterface.class);
		
		likeCnt = likeMessageDao.getCountLikeMessage(messageId);

		System.out.println("카운트라이크메세지서비스 - likeCnt : " + likeCnt);

		int onlyLikeCnt = 0;
		
		if(likeCnt==null) {
			onlyLikeCnt = 0;
		} else {
		onlyLikeCnt = likeCnt.getLikeCnt();
		}
		return onlyLikeCnt;
	}
}
