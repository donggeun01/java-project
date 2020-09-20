package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		
		System.out.println("어노테이션 loginController 작동 GET");

		vo.setId("a");
		vo.setPassword("12");
		return "login.jsp";
	}
	
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO UserDAO, HttpSession session) {
			
		UserVO user = UserDAO.getUser(vo);
		System.out.println("어노테이션 loginController 작동 POST");
		
		if (UserDAO.getUser(vo) != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else {
			return "login.jsp";
		}
	}

}
