package com.bitcamp.openprac2.msgservice;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.LikeMessageDaoInterface;
import com.bitcamp.openprac2.model.LikeMessageDTO;

@Service
public class IsLikeMessageService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LikeMessageDaoInterface likeMessageDao;
	
	@Transactional
	public List<LikeMessageDTO> isLikeMessage(int userIdx) {
		likeMessageDao = sqlSessionTemplate.getMapper(LikeMessageDaoInterface.class);
		
		List<LikeMessageDTO> likeMessages = new ArrayList<LikeMessageDTO>();
		
		likeMessages = likeMessageDao.getLikeMessages(userIdx);
		
		
		LikeMessageDTO likeMessage = new LikeMessageDTO();
		likeMessage.setMessageId(-1);
		likeMessage.setUserIdx(userIdx);
		
		if(likeMessages.isEmpty()) {
			likeMessages.add(likeMessage);
		}
		return likeMessages;
	}
}
