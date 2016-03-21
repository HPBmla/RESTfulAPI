package com.projects.api.messanger.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.projects.api.messanger.dao.DbConnection;
import com.projects.api.messanger.model.Message;

public class Service {
	
	
	
	private Map<Long, Message> messages = DbConnection.getMessages();

	public Service()
	{
		messages.put(1L, new Message(1,"Im going to classes","Bimla"));
		messages.put(2L, new Message(2,"It's a holiday tommorrow","Nishadhi"));
	}
	
	
	public List<Message> getAllMessages()
	{
		
	return new ArrayList<Message>(messages.values());
		
	}
	
	public Message getSingleMessage(long uId)
	{
		return messages.get(uId);
	}
	public Message insertMessage(Message msg)
	{
		msg.setMessageId(messages.size() + 1);
		messages.put(msg.getMessageId(), msg);
		return msg;
	}
	
	public Message editMessage(Message msg)
	{
		if(msg.getMessageId() <= 0)
		{
			return null;
		}
		else
		{
			messages.put(msg.getMessageId(), msg);
			return msg;
		}
	}
	public Message deleteMsg(long id)
	{
		return messages.remove(id);
	}
    
	public List<Message> getMessagesByYear(int year)
	{
		List<Message> msgsInYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for(Message msg : messages.values())
		{
			calendar.setTime(msg.getCreatedDte());
			if(calendar.get(Calendar.YEAR) == year)
			{
				msgsInYear.add(msg);
			}
		}
		return  msgsInYear;
		
	}
	
	
	public List<Message> getMessgePaginate(int begin, int end)
	{
		
		ArrayList<Message> msgList = new ArrayList<Message>(messages.values());
		if(begin + end >msgList.size() )
			return new ArrayList<Message>();
		
		  return msgList.subList(begin, begin+end); 
	}
}
