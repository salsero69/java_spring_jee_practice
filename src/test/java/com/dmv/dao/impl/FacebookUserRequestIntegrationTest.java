package com.dmv.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dmv.bo.UserBO;
import com.dmv.dao.SocialUserRequest;

public class FacebookUserRequestIntegrationTest {

	@Test
	public void validateValidRequest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
		
		SocialUserRequest request = (FacebookUserRequest) context.getBean("facebookUserDAO");
		UserBO user = request.getUser("don.vaillancourt");

		Assert.assertTrue(user.getFirstName() instanceof String);
		Assert.assertTrue(user.getLastName() instanceof String);

		System.out.println("Username: " + user.getFirstName());
		System.out.println("Lastname: " + user.getLastName());
	}
}
