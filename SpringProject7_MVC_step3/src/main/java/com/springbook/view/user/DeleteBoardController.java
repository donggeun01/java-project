package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class DeleteBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		System.out.println("�� ���� ó�� MVC�����ӿ�ũ");
		
		String seq = request.getParameter("seq");
	    
	    vo.setSeq(Integer.parseInt(seq));
	    
    	boardDAO.deleteBoard(vo);
    	
    	// 3. ȭ�� �׺���̼�
    	return "getBoardList.do";
	}

}
