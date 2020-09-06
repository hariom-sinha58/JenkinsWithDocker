package com.example.resume.controller;

import java.text.ParseException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume.modal.BlogData;
import com.example.resume.modal.BlogRequestPayLoad;
import com.example.resume.modal.BlogResponsePayLoad;
import com.example.resume.service.BlogDataService;

import ch.qos.logback.classic.Logger;

@RestController
public class BlogController {
	
	@Autowired
	BlogDataService blogDataService;
	
	public static Logger logger = (Logger) LoggerFactory.getLogger(BlogController.class);
	
	public void testBlogController() {
		logger.info("test blog controller works !!");
	}
	
	
	@RequestMapping(value = "/saveBlog", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<BlogResponsePayLoad> saveLatestBlog(@RequestBody BlogRequestPayLoad blogRequestPayLoad) throws ParseException {
		
		logger.info("save blog controller request received !!");
		//for logging purpose
		blogDataService.displayPayLoad(blogRequestPayLoad);
		
		//store in Modal
		BlogData blogData = blogDataService.createBlogModal(blogRequestPayLoad);
		
		//save Modal in Repo
		blogDataService.saveBlogModal(blogData);
		
		//create response body
		BlogResponsePayLoad blogResponsePayLoad = blogDataService.createBlogResponse(blogData);
		
		logger.info("save blog controller response sent with header and body !!");
		return ResponseEntity.ok()
				.header("status", "saved")
				.body(blogResponsePayLoad);
				
	}
}

