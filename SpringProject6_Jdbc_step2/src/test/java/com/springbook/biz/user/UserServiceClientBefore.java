package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClientBefore {
	public static void main(String[] args) {
		// 1. Spring 而⑦뀒�씠�꼫瑜� 援щ룞�븳�떎.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 而⑦뀒�씠�꼫濡쒕��꽣 UserServiceImpl 媛앹껜瑜� Lookup �븳�떎.
		UserService userService = (UserService) container.getBean("userService");

		// 3. 濡쒓렇�씤 湲곕뒫 �뀒�뒪�듃
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("1234");

		UserVO user = userService.getUser(vo);
		if (user != null) {
			System.out.println(user.getName() + "�떂 �솚�쁺�빀�땲�떎.");
		} else {
			System.out.println("濡쒓렇�씤 �떎�뙣");
		}

		// 4. Spring 而⑦뀒�씠�꼫瑜� 醫낅즺�븳�떎.
		container.close();
	}
}