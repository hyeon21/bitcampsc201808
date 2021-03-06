package com.bitcamp.mvc1113;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message-list")
public class GuestMessageList {

	@XmlElement(name = "message") // 반환 타입 지정
	private List<GuestMessage> messages;

	public GuestMessageList() {
	}

	public GuestMessageList(List<GuestMessage> messages) {
		this.messages = messages;
	}

	public List<GuestMessage> getMessages() {
		return messages;
	}

}
