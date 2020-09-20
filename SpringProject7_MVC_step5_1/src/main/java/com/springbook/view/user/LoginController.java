package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


@Controller
public class LoginController {

		@RequestMapping("/login.do")
		public String login(UserVO vo, UserDAO UserDAO) {
			
			System.out.println("어노테이션 loginController 작동");

			if (UserDAO.getUser(vo) != null) {
				return "redirect:getBoardList.do";
			}
			else {
				return "redirect:login.jsp";
			}
		}

}
