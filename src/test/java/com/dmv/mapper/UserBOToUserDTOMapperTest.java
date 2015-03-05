package com.dmv.mapper;

import junit.framework.Assert;

import org.junit.Test;

import com.dmv.bo.UserBO;
import com.dmv.dto.FacebookUserDTO;

public class UserBOToUserDTOMapperTest {
	private static final String FIRST_NAME = "James";
	private static final String LAST_NAME = "Brown";
	
	
	@Test
	public void validateUserBOtoFacebookUserDTOTest()
	{
		UserBOToUserDTOMapper mapper = new UserBOToUserDTOMapper();
		
		UserBO user = new UserBO();
		
		user.setFirstName(FIRST_NAME);
		user.setLastName(LAST_NAME);
		
		FacebookUserDTO newUser = mapper.convert(user);
		
		Assert.assertEquals(FIRST_NAME, newUser.getFirst_name());
		Assert.assertEquals(LAST_NAME, newUser.getLast_name());
	}
	
	@Test
	public void validateFacebookUserDTOToUserBOTest()
	{
		UserBOToUserDTOMapper mapper = new UserBOToUserDTOMapper();
		
		FacebookUserDTO user = new FacebookUserDTO();
		
		user.setFirst_name(FIRST_NAME);
		user.setLast_name(LAST_NAME);
		
		UserBO newUser = mapper.convert(user);
		
		Assert.assertEquals(FIRST_NAME, newUser.getFirstName());
		Assert.assertEquals(LAST_NAME, newUser.getLastName());
	}	
	
}
