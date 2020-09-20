package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;


public class UpdateBoardController implements Controller{

		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			System.out.println("글 수정 처리 MVC프레임워크");
			
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			vo.setTitle(title);
	    	vo.setContent(content);
	    	vo.setSeq(Integer.parseInt(seq));
	    	
	    	boardDAO.updateBoard(vo);
	    	
	    	// 3. 화면 네비게이션
	    	ModelAndView mav = new ModelAndView();
	    	mav.setViewName("redirect:getBoardList.do");
	    	
	    	return mav;
		}


}
