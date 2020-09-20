<%@page import="com.springbook.biz.board.impl.BoardDAOMybatis2"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <%
    	// 1. 사용자 입력 정보 추출
    	request.setCharacterEncoding("utf-8");
	    String title = request.getParameter("title");
		String content = request.getParameter("content");
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
    	vo.setContent(content);
    	vo.setSeq(Integer.parseInt(seq));
    	
    	BoardDAOMybatis2 boardDAO = new BoardDAOMybatis2();
    	boardDAO.updateBoard(vo);
    	
    	// 3. 화면 네비게이션
    	response.sendRedirect("getBoardList.jsp");
    %>