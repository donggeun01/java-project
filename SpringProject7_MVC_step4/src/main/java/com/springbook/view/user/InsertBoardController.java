package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller{


		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			
			System.out.println("�� ��� ó�� MVC�����ӿ�ũ");
			
			String title = request.getParameter("title");
	    	String writer = request.getParameter("writer");
	    	String content = request.getParameter("content");
	    	
	    	// DB���� ó�� 
	    	vo.setTitle(title);
	    	vo.setWriter(writer);
	    	vo.setContent(content);
	    	boardDAO.insertBoard(vo);
	    	
	    	
	    	
	    	// 3. ȭ�� �׺���̼�
	    	ModelAndView mav = new ModelAndView();
	    	mav.setViewName("redirect:getBoardList.do");
	    	
	    	return mav;
	    	
	    	
		}
    	
	

}
