package com.dmv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.dmv.bo.UserBO;
import com.dmv.dao.SocialUserRequest;
import com.dmv.dto.FacebookUserDTO;
import com.dmv.mapper.UserBOToUserDTOMapper;

public class FacebookUserRequest implements SocialUserRequest {
	public RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public UserBO getUser(String user) {
		UserBOToUserDTOMapper mapper = new UserBOToUserDTOMapper();
		List<HttpMessageConverter<?>> converter = new ArrayList<HttpMessageConverter<?>>();
		
		converter.add(new GsonHttpMessageConverter());
		
        String uri = "http://graph.facebook.com/" + user;
        
        restTemplate.setMessageConverters(converter);
		FacebookUserDTO facebookUser = restTemplate.getForObject(uri, FacebookUserDTO.class);
        //HttpHeaders headers = restTemplate.headForHeaders(uri);
        //String link = headers.get("Link").get(0);
        
		return mapper.convert(facebookUser);
	}

}
