package com.dmv.web;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dmv.bean.UserInfoBean;
import com.dmv.bo.UserBO;
import com.dmv.dao.SocialUserRequest;
import com.dmv.dao.impl.FacebookUserRequest;

@Controller
public class HomeController {

	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
	
	@RequestMapping(value="/", method=GET)
	public String home()
	{
		SocialUserRequest userRequest = (FacebookUserRequest) context.getBean("facebookUserDAO");
		UserInfoBean bean = (UserInfoBean) context.getBean("userInfo");
		
		UserBO user = userRequest.getUser("don.vaillancourt");
		
		bean.setUser(user);
		
		return "home";
	}
}
