package com.bitcamp.openprac2.dao;

import java.util.List;

import com.bitcamp.openprac2.model.CommentDTO;

public interface CommentDaoInterface {
	
	public void insertComment(CommentDTO commentDTO);
	public List<CommentDTO> selectCommentList(int messageId);
	public void deleteComment(int commentNo);
	public void deleteCommentAll(int messageId);
	public void updateComment(String comment, int commentNo);
}
