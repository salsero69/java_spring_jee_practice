package com.dmv.dao.impl;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.*;

import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.dmv.bo.UserBO;
import com.dmv.dto.FacebookUserDTO;
import com.dmv.mapper.UserBOToUserDTOMapper;

public class FacebookUserRequestMockedTest {
	private static final String FIRST_NAME = "James";
	private static final String LAST_NAME = "Brown";	
	private static final String URI = "http://www.test.com";
	
	private FacebookUserDTO user = new FacebookUserDTO();
	
	@Mock
	private RestTemplate restTemplate = new RestTemplate();
	
	@InjectMocks
	private FacebookUserRequest request;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);

		user.setFirst_name(FIRST_NAME);
		user.setLast_name(LAST_NAME);
		
		when(restTemplate.getForObject(anyString(), eq(FacebookUserDTO.class))).thenReturn(user);
	}
	
	@Test
	public void validateValidRequest()
	{
		UserBO user = request.getUser(URI);
		
		Assert.assertEquals(FIRST_NAME, user.getFirstName());
		Assert.assertEquals(LAST_NAME, user.getLastName());		
	}
}
