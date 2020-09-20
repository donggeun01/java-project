package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class UserServiceCllient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContextAfter.xml");
		
		// 2. Spring 컨테이너로부터 BoardService 객체를 Lookup한다.
		UserService userService = (UserService) container.getBean("userService");
		
		// 3. 글 등록 기능 테스트
		UserVO vo = new UserVO();
		
		vo.setId("a");
		vo.setPassword("12");
		
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");		
		}
		
		else {
			System.out.println("로그인 실패");
		}

	}

}
