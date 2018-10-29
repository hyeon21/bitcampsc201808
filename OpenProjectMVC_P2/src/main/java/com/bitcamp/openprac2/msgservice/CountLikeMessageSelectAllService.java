package com.bitcamp.openprac2.msgservice;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bitcamp.openprac2.dao.LikeMessageDaoInterface;
import com.bitcamp.openprac2.model.CountLikeMessageDTO;

public class CountLikeMessageSelectAllService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private LikeMessageDaoInterface likeMessageDao;
	
	@Transactional
	public List<CountLikeMessageDTO> getCountLikeMessageAll(){
		
		List<CountLikeMessageDTO> likeList = new ArrayList<CountLikeMessageDTO>();
		
		likeMessageDao = sqlSessionTemplate.getMapper(LikeMessageDaoInterface.class);
		
		likeList = likeMessageDao.selectLikeMessageAll();
		
		return likeList;
	}
}
