package com.bitcamp.openprac2.model;

public class CountMessageLike {

	private int messageId;
	private int likeCnt;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	@Override
	public String toString() {
		return "CountMessageLike [messageId=" + messageId + ", likeCnt=" + likeCnt + "]";
	}

}
