package com.projects.api.messanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.projects.api.messanger.dao.DbConnection;
import com.projects.api.messanger.model.Message;
import com.projects.api.messanger.model.UserProfiles;

public class UserProfileServices {
	
	 private  Map<String, UserProfiles> profile = DbConnection.getProfiles();
	 
	 public UserProfileServices()
	 {
		 profile.put("Bimla", new UserProfiles(1L,"bmla","Bimla","Madhavee"));
	 }
	 public List<UserProfiles> getAllProfiles()
		{
			
		return new ArrayList<UserProfiles>(profile.values());
			
		}
     
	 public UserProfiles createProfile(UserProfiles profiles)
		{
		 System.out.println("this is "+profiles);
		    profiles.setUserId(profile.size() + 1);
			profile.put(profiles.getProfName(), profiles);
			return profiles;
		}
	 
	 public UserProfiles getSingleProfile(String pName)
		{  
		    System.out.println("my name is "+pName);
			return profile.get(pName);
		}
	 
	 public UserProfiles editProfile(UserProfiles prof)
		{
			if(prof.getProfName().isEmpty())
			{
				return null;
			}
			else
			{
				profile.put(prof.getProfName(), prof);
				return prof;
			}
		}
	 public UserProfiles deleteProfile(String profName)
		{
			return profile.remove(profName);
		}
	 
}
