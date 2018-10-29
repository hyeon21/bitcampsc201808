package com.bitcamp.openprac2.model;

public class Message {

	private int messageId;
	private String userId;
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", userId=" + userId + ", message=" + message + "]";
	}
}
