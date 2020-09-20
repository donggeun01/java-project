package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;


public class LoginController implements Controller{

		
	
		

		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			System.out.println("로그인 처리 MVC프레임워크");

			// 1. 사용자 입력 정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			UserVO vo = new UserVO();
			UserDAO userDAO = new UserDAO();

			// 2. DB �뿰�룞 泥섎━
			
			vo.setId(id);
			vo.setPassword(password);

			UserVO user = userDAO.getUser(vo);

			// 3. 화면 네비게이션
			ModelAndView mav = new ModelAndView();
			if (user != null) {
				mav.setViewName("redirect:getBoardList.do");
			} 
			
			else {
				mav.setViewName("redirect:login,jsp");
			}
			
			return mav;
		}

}
