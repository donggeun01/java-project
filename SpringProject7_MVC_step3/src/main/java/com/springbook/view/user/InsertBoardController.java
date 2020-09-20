package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.view.controller.Controller;

public class InsertBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		System.out.println("글 등록 처리 MVC프레임워크");
		
		String title = request.getParameter("title");
    	String writer = request.getParameter("writer");
    	String content = request.getParameter("content");
    	
    	// DB연동 처리 
    	vo.setTitle(title);
    	vo.setWriter(writer);
    	vo.setContent(content);
    	boardDAO.insertBoard(vo);
    	
    	// 3. 화면 네비게이션
    	return "getBoardList.do";
	}

}
