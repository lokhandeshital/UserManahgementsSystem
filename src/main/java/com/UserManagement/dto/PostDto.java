package com.UserManagement.dto;

import java.util.Date;

import com.UserManagement.beans.User;

public class PostDto {

	public String title;

	public String content;

	public String imagename;

	public Date addeddate;

	private User user;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public Date getAddeddate() {
		return addeddate;
	}

	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(String title, String content, String imagename, Date addeddate, User user) {
		super();
		this.title = title;
		this.content = content;
		this.imagename = imagename;
		this.addeddate = addeddate;
		this.user = user;
	}

	@Override
	public String toString() {
		return "PostDto [title=" + title + ", content=" + content + ", imagename=" + imagename + ", addeddate="
				+ addeddate + ", user=" + user + "]";
	}
	
	
}
