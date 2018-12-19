package com.bitcamp.mvc1113;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class GuestMessageList2 {

	private List<GuestMessage2> messages;

	public GuestMessageList2() {
	}

	public GuestMessageList2(List<GuestMessage2> messages) {
		this.messages = messages;
	}

	public List<GuestMessage2> getMessages() {
		return messages;
	}

}
