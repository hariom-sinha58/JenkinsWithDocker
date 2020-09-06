package com.example.resume.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.resume.controller.BlogController;
import com.example.resume.modal.BlogData;
import com.example.resume.modal.BlogRequestPayLoad;
import com.example.resume.modal.BlogResponsePayLoad;
import com.example.resume.repo.BlogDataRepository;

import ch.qos.logback.classic.Logger;

@Service
public class BlogDataService {

		@Autowired
		BlogDataRepository blogDataRepository;
		public static Logger logger = (Logger) LoggerFactory.getLogger(BlogDataService.class);
		public BlogData createBlogModal(BlogRequestPayLoad blogRequestPayLoad) throws ParseException {
			
			logger.info("creating a modal for BlogData");
			
			BlogData blogData = new BlogData();

			blogData.setBlogName(blogRequestPayLoad.getBlogName());
			blogData.setBlogDate(new SimpleDateFormat("dd-MM-yyyy").parse(blogRequestPayLoad.getBlogDate()));
			blogData.setBlogContent(blogRequestPayLoad.getBlogContent());
			
			logger.info("Blogdata Created");
			
			return blogData;
		}
		
		public void saveBlogModal(BlogData blogData) {
			
			logger.info("saving BlogData inside Repo");
			blogDataRepository.save(blogData);
			logger.info("BlogData Repo created for the instance");
	
		}
		
		public BlogResponsePayLoad createBlogResponse(BlogData blogData) {
			
			logger.info("creating response body for blog data");
			BlogResponsePayLoad blogResponsePayLoad = new BlogResponsePayLoad();
			

			blogResponsePayLoad.setBlogName(blogData.getBlogName());
			blogResponsePayLoad.setBlogDate(blogData.getBlogDate().toString());
			blogResponsePayLoad.setBlogContent(blogData.getBlogContent());
			logger.info("response body for blog data created");
			return blogResponsePayLoad;
		}
		
		public void displayPayLoad(BlogRequestPayLoad blogRequestPayLoad) {
			
			logger.info("payload received is :");
			logger.info(blogRequestPayLoad.getBlogName());
			logger.info(blogRequestPayLoad.getBlogContent());
			logger.info(blogRequestPayLoad.getBlogDate());
			
		}
}
