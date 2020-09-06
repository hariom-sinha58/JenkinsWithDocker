package com.example.resume.modal;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="BlogDataTable")
public class BlogData {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	int id;
	String blogName;
	String blogContent;
	Date BlogDate;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public Date getBlogDate() {
		return BlogDate;
	}
	public void setBlogDate(Date date) {
		BlogDate = date;
	}
}
