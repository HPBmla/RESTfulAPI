package com.projects.api.messanger.resource;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.projects.api.messanger.model.Message;
import com.projects.api.messanger.resource.bean.MessageBean;
import com.projects.api.messanger.service.Service;


@Path("/messages")
public class MessagesResource {
	
	Service msgService = new Service();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> showMessages(@BeanParam MessageBean msgBean)
	{
		if(msgBean.getYear() > 0)
		{
			return msgService.getMessagesByYear(msgBean.getYear());
		}
		
		if(msgBean.getBegin() >= 0 && msgBean.getEnd() >= 0)
		{
			return msgService.getMessgePaginate(msgBean.getBegin(), msgBean.getEnd());
		}
		return msgService.getAllMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message insertMessage(Message message)
	{
		return msgService.insertMessage(message);
	}
	
	@PUT
	@Path("/edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Message editMessage(@QueryParam("messageId") long id,Message msg)
	{
		msg.setMessageId(id);
		return msgService.editMessage(msg);
	}
	
	
	
	/*@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getSingleMessage(@PathParam("messageId") String Id){
		
		System.out.println("This is "+Id);
		return null;
		
	}*/
	@GET
	@Path("/abc")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getSingleMessage(@QueryParam("messageId") String Id){
		
		System.out.println("This is "+Id);
		return msgService.getSingleMessage(Long.parseLong(Id));
		
	}
	@DELETE
	@Path("/abc")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMessage(@QueryParam("messageId") String Id)
	{
		msgService.deleteMsg(Long.parseLong(Id));
		return "messages deleted with the id ="+Id;
	}
	
	@GET
	@Path("/messageId/comments")
	public CommentsResource getComments()
	{
		return new CommentsResource();
	}

}
