package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LogoutController{

	// logout 컨트롤러
		@RequestMapping("/logout.do")
		public String logout(HttpSession session) {
			System.out.println("어노테이션 logoutController 작동");

			
			// 1. 釉뚮씪�슦���� �뿰寃곕맂 �꽭�뀡 媛앹껜瑜� 媛뺤젣 醫낅즺�븳�떎.
			session.invalidate();
			// 2. �꽭�뀡 醫낅즺 �썑, 硫붿씤 �솕硫댁쑝濡� �씠�룞�븳�떎.
			
			return "login.jsp";
		}

}
