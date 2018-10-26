package com.bitcamp.openprac2.dao;


import java.util.List;

import com.bitcamp.openprac2.model.CountMessageLike;
import com.bitcamp.openprac2.model.MessageLike;

public interface MessageLikeDaoInterface {

	public MessageLike selectMessageLike(MessageLike messageLike);
	public int insertMessageLike(MessageLike messageLike);
	public int deleteMessageLike(MessageLike messageLike);
	public List<CountMessageLike> countMessageLike();
}
