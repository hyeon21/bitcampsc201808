package com.bitcamp.openprac2.msgservice;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.LikeMessageDaoInterface;
import com.bitcamp.openprac2.model.CountLikeMessageDTO;
import com.bitcamp.openprac2.model.LikeMessageDTO;
import com.bitcamp.openprac2.model.Message;

public class GetLikeCountAllService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LikeMessageDaoInterface likeMessageDao;
	
	@Transactional
	public List<CountLikeMessageDTO> getLikeCountAll(){
		
		likeMessageDao = sqlSessionTemplate.getMapper(LikeMessageDaoInterface.class);
		
		System.out.println("getLikeCountAll 진입");
		
		List<Message> messageAllList = new ArrayList<Message>();
		
		List<CountLikeMessageDTO> likeCntAllList = new ArrayList<CountLikeMessageDTO>();
		
		CountLikeMessageDTO likeCntDTO = new CountLikeMessageDTO();
		
		List<Integer> msgIdList = new ArrayList<Integer>();
		
		messageAllList = likeMessageDao.getMessageAll();
			
		for(int i=0; i<messageAllList.size(); i++) {
			//likeCntAllList.add(likeMessageDao.getCountLikeMessage(messageAllList.get(i).getMessageId()));
			msgIdList.add(messageAllList.get(i).getMessageId());
		}
		
		for(int i=0; i<msgIdList.size(); i++) {
			likeCntDTO = likeMessageDao.getCountLikeMessage(msgIdList.get(i));
			if(likeCntDTO==null) {
				likeCntDTO = new CountLikeMessageDTO();
				likeCntDTO.setMessageId(msgIdList.get(i));
				likeCntDTO.setLikeCnt(0);
			}
			likeCntAllList.add(likeCntDTO);
		}
		System.out.println("likeCntAllList : "+likeCntAllList);
		
		return likeCntAllList;
	}
	

}
