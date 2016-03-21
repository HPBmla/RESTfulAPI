package com.projects.api.messanger.model;

import java.util.Date;

public class UserProfiles {
	
private long userId;
private String profName;
private String fname;
private String lname;
private Date createdDate;

public UserProfiles()
{
	
}


public UserProfiles(long id,String profNme, String first, String last)
{
	userId = id;
	profName = profNme;
	fname = first;
	lname = last;
	this.createdDate = new Date();
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}


public String getProfName() {
	return profName;
}


public void setProfName(String profName) {
	this.profName = profName;
}
}
