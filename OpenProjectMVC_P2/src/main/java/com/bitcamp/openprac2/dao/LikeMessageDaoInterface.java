package com.bitcamp.openprac2.dao;


import java.util.List;

import com.bitcamp.openprac2.model.CountLikeMessageDTO;
import com.bitcamp.openprac2.model.LikeMessageDTO;

public interface LikeMessageDaoInterface {

	public LikeMessageDTO selectLikeMessage(LikeMessageDTO likeMessage);
	public int insertLikeMessage(LikeMessageDTO likeMessage);
	public int deleteLikeMessage(LikeMessageDTO likeMessage);
	public List<CountLikeMessageDTO> countLikeMessage();
}
