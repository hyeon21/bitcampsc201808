package com.bitcamp.openprac2.model;

public class MessageLike {

	private int messageId;
	private int userIdx;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	@Override
	public String toString() {
		return "MessageLike [messageId=" + messageId + ", userIdx=" + userIdx + "]";
	}

}
