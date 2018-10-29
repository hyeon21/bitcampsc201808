package com.bitcamp.openprac2.dao;


import java.util.List;

import com.bitcamp.openprac2.model.CountLikeMessageDTO;
import com.bitcamp.openprac2.model.LikeMessageDTO;
import com.bitcamp.openprac2.model.Message;

public interface LikeMessageDaoInterface {

	public LikeMessageDTO selectLikeMessage(LikeMessageDTO likeMessage);
	public void insertLikeMessage(LikeMessageDTO likeMessage);
	public int deleteLikeMessage(LikeMessageDTO likeMessage);
	public CountLikeMessageDTO getCountLikeMessage(int messageId);
	public List<CountLikeMessageDTO> selectLikeMessageAll();
	public List<Message> getMessageAll();
}
