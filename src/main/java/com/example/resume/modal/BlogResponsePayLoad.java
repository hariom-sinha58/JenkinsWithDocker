package com.example.resume.modal;

import java.sql.Date;

public class BlogResponsePayLoad {

	String blogName;
	String blogContent;
	String BlogDate;
	
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
	public String getBlogDate() {
		return BlogDate;
	}
	public void setBlogDate(String blogDate) {
		BlogDate = blogDate;
	}
		
}