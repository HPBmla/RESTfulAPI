package com.projects.api.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

public class Message {

	private long messageId;
	private Date createdDte;
	private String message;
	private String sender;
	
	
	
	public Message()
	{
		
	}
	
	

	public Message(long id, String msg, String authr)
	
	{
		messageId = id;
		this.createdDte = new Date();
		message = msg;
		sender = authr;
		
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public long getMessageId() {
		return messageId;
	}
	
	
	
	
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public Date getCreatedDte() {
		return createdDte;
	}
	public void setCreatedDte(Date createdDte) {
		this.createdDte = createdDte;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	
	
}
