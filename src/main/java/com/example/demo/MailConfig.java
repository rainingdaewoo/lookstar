package com.example.demo;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailConfig {
	@Bean
	public JavaMailSenderImpl javaMailSender() {
		System.out.println("mail객체생성됨");
		JavaMailSenderImpl r = new JavaMailSenderImpl();
		r.setHost("smtp.gmail.com");
		r.setPort(587);
		r.setUsername("rladudtjrwkd");
		r.setPassword("hocdhmqfyyvrfmwg");
		r.setDefaultEncoding("UTF-8");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.checkserveridentity", true);
		prop.put("mail.smtp.ssl.trust","*");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		r.setJavaMailProperties(prop);
		return r; 
	}
}
