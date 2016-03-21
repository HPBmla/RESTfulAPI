package com.projects.api.messanger.resource;

import java.util.List;

import javax.websocket.server.PathParam;
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
import com.projects.api.messanger.model.UserProfiles;
import com.projects.api.messanger.service.UserProfileServices;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)



public class UserProfileResource {
	
	 UserProfileServices profileService = new UserProfileServices();
	
	@GET
	public List<UserProfiles> viewProfiles()
	{
		return profileService.getAllProfiles();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserProfiles createProfile(UserProfiles profle)
	{
		System.out.println("this is "+profle);
		return profileService.createProfile(profle);
	}
	
	@GET
	@Path("/prof")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public UserProfiles getSingleProfile(@QueryParam("profName") String profName){
		
		System.out.println("This is "+profName);
		return profileService.getSingleProfile(profName);
		
	}
	
	@PUT
	@Path("/profilename")
	public UserProfiles editProfile(@QueryParam("pName") String profName,UserProfiles profile)
	{
		profile.setProfName(profName);
		return profileService.editProfile(profile);
	}
	
	@DELETE
	@Path("/profilename")
	public String deleteProfile(@QueryParam("profName") String profName)
	{
		
		profileService.deleteProfile(profName);
		return "messages deleted with the id ="+profName;
	}
	
	

}
