package com.example.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.resume.service.EmailService;

@SpringBootApplication
public class ResumeWebsiteApplication  {
	
	@Autowired
	EmailService emailService;

	@Bean
	public  WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer()
		{	
			public void addCorsMapping(CorsRegistry registry)
			{
				registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*").allowCredentials(true);

			}
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ResumeWebsiteApplication.class, args);
	}

	public void run(String... args) 
	{
		

	}

}
