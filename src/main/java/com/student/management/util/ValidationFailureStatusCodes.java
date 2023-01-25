package com.student.management.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ValidationMessages.properties")
public class ValidationFailureStatusCodes {
	
	@Value("${validation.student.alreadyExists}")
	private String emailAlreadyExists;

	public String getEmailAlreadyExists() {
		return emailAlreadyExists;
	}

	public void setEmailAlreadyExists(String emailAlreadyExists) {
		this.emailAlreadyExists = emailAlreadyExists;
	}
	
	

}
