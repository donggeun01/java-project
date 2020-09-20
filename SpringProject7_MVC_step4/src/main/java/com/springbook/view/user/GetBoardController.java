package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


public class GetBoardController implements Controller{


		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			
			System.out.println("글 상세 조회 처리 MVC프레임워크");
			
			String seq = request.getParameter("seq");
	    	vo.setSeq(Integer.parseInt(seq));
	    	BoardVO board = boardDAO.getBoard(vo);
	    	
	    	HttpSession session = request.getSession();
	    	
	    	session.setAttribute("board", board);
	    	
	    	ModelAndView mav = new ModelAndView();
	    	mav.addObject("board", board);
	    	mav.setViewName("getBoard");
	    	
	    	return mav;
		}

    	

}
