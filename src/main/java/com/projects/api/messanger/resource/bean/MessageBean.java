package com.projects.api.messanger.resource.bean;

import javax.ws.rs.QueryParam;

public class MessageBean {
	
	private @QueryParam("year") int year;
	private  @QueryParam("begin") int begin;
	private  @QueryParam("end") int end;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

}
