package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class UpdateBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
    	return "getBoardList.do";
	}
	

}
