package com.bitcamp.openprac2.model;

import java.util.Date;

public class CommentDTO {

	private int commentNo; // 덧글번호
	private int messageId; // 원 게시글 번호
	private String userId; // 덧글 작성자 아이디
	private String comment; // 덧글 내용
	private Date commentDate; // 덧글 작성시간

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentNo=" + commentNo + ", messageId=" + messageId + ", userId=" + userId + ", comment="
				+ comment + ", commentDate=" + commentDate + "]";
	}

}
