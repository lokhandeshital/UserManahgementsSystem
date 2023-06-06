package com.UserManagement.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer postid;

	@Column(name = "post_title", length = 100, nullable = false)
	public String title;

	@Column(name = "post_content", length = 100, nullable = false)
	public String content;

	@Column(name = "post_image")
	public String imagename;

	@Column(name = "post_date")
	public Date addeddate;

	@ManyToOne
	private User user;

	public Post(Integer postid, String title, String content, String imagename, Date addeddate, User user) {
		super();
		this.postid = postid;
		this.title = title;
		this.content = content;
		this.imagename = imagename;
		this.addeddate = addeddate;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

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

	public Post(Integer postid, String title, String content, String imagename, Date addeddate) {
		super();
		this.postid = postid;
		this.title = title;
		this.content = content;
		this.imagename = imagename;
		this.addeddate = addeddate;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Post [postid=" + postid + ", title=" + title + ", content=" + content + ", imagename=" + imagename
				+ ", addeddate=" + addeddate + "]";
	}

}
