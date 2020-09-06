package com.example.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.resume.dto.DownloadResume;
import com.example.resume.modal.EmailPayLoad;
import com.example.resume.service.EmailService;

@RestController
@CrossOrigin(origins="*")
public class EmailController {
	
		public static Logger logger = LoggerFactory.getLogger(EmailController.class);
		
		@Autowired
		EmailService emailService;
		
	
		DownloadResume downloadResumeDto;
		
		@RequestMapping(value="/sendEmail", method = RequestMethod.POST, produces="application/json")
		public ResponseEntity<DownloadResume> sendEmail(@RequestBody EmailPayLoad emailPayLoad) {
			logger.info("email send request received");
			String subject = "Email :  "+emailPayLoad.getEmail()+" Contact : "+emailPayLoad.getContact();
			String message = emailPayLoad.getMessage();
			System.out.println(subject + "" + message);
			emailService.sendMail("strangerdevelopment@gmail.com", subject, message);
			System.out.println("email sent");
			logger.info("email send request success");
			downloadResumeDto = new DownloadResume();
			downloadResumeDto.setStatus("success");
			return ResponseEntity.ok().body(downloadResumeDto);
					
		}
}
