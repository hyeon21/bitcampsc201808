package com.bitcamp.mvc1113;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

public class GuestMessage2 {

	private Integer id;
	private String message;
	private Date creationTime;

	public GuestMessage2() {
	}

	public GuestMessage2(Integer id, String message, Date creationTime) {
		this.id = id;
		this.message = message;
		this.creationTime = creationTime;
	}

	public Integer getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

}
