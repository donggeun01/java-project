package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


public class DeleteBoardController implements Controller{


		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			
			System.out.println("글 삭제 처리 MVC프레임워크");
			
			String seq = request.getParameter("seq");
			vo.setSeq(Integer.parseInt(seq));
		    
	    	boardDAO.deleteBoard(vo);
	    	
	    	// 3. 화면 네비게이션
	    	ModelAndView mav = new ModelAndView();
	    	
	    	mav.setViewName("redirect:getBoardList.do");
	    	
	    	return mav;
		}
	    
	    
	
    	
}
