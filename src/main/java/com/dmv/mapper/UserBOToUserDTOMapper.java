package com.dmv.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

import com.dmv.bo.UserBO;
import com.dmv.dto.FacebookUserDTO;

public class UserBOToUserDTOMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
		factory.classMap(FacebookUserDTO.class, UserBO.class)
				.field("first_name", "firstName")
				.field("last_name", "lastName").byDefault().register();
	}

	public UserBO convert(FacebookUserDTO user) {
		return this.map(user, UserBO.class);

	}

	public FacebookUserDTO convert(UserBO user) {
		return this.map(user, FacebookUserDTO.class);

	}

}
