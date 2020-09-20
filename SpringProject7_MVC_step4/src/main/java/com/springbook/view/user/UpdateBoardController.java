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
			
			System.out.println("�� ���� ó�� MVC�����ӿ�ũ");
			
			BoardVO vo = new BoardVO();
			BoardDAO boardDAO = new BoardDAO();
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			vo.setTitle(title);
	    	vo.setContent(content);
	    	vo.setSeq(Integer.parseInt(seq));
	    	
	    	boardDAO.updateBoard(vo);
	    	
	    	// 3. ȭ�� �׺���̼�
	    	ModelAndView mav = new ModelAndView();
	    	mav.setViewName("redirect:getBoardList.do");
	    	
	    	return mav;
		}


}
