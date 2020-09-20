package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		process(request, response);

	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. �겢�씪�씠�뼵�듃�쓽 �슂泥� path �젙蹂대�� 異붿텧�븳�떎.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		System.out.println(uri);
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		UserVO uvo = new UserVO();
		UserDAO userDAO = new UserDAO();

		// 2. �겢�씪�씠�뼵�듃�쓽 �슂泥� path�뿉 �뵲�씪 �쟻�젅�엳 遺꾧린泥섎━ �븳�떎.
		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");

			// 1. �궗�슜�옄 �엯�젰 �젙蹂� 異쒕젰
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB �뿰�룞 泥섎━
			
			uvo.setId(id);
			uvo.setPassword(password);
	
			UserVO user = userDAO.getUser(uvo);

			// 3. �솕硫� �꽕鍮꾧쾶�씠�뀡
			if (user != null) {
				response.sendRedirect("getBoardList.do");
				System.out.println("리다이렉트 확인");
			} else {
				response.sendRedirect("login.jsp");
			}

		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");

			HttpSession session = request.getSession();
			// 1. 釉뚮씪�슦���� �뿰寃곕맂 �꽭�뀡 媛앹껜瑜� 媛뺤젣 醫낅즺�븳�떎.
			session.invalidate();
			// 2. �꽭�뀡 醫낅즺 �썑, 硫붿씤 �솕硫댁쑝濡� �씠�룞�븳�떎.
			response.sendRedirect("login.jsp");

		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			String title = request.getParameter("title");
	    	String writer = request.getParameter("writer");
	    	String content = request.getParameter("content");
	    	
	    	// DB연동 처리 
	    	vo.setTitle(title);
	    	vo.setWriter(writer);
	    	vo.setContent(content);
	    	boardDAO.insertBoard(vo);
	    	
	    	// 3. 화면 네비게이션
	    	response.sendRedirect("getBoardList.do");
	    	
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			vo.setTitle(title);
	    	vo.setContent(content);
	    	vo.setSeq(Integer.parseInt(seq));
	    	
	    	boardDAO.updateBoard(vo);
	    	
	    	// 3. 화면 네비게이션
	    	response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			String seq = request.getParameter("seq");
		    
		    vo.setSeq(Integer.parseInt(seq));
		    
	    	boardDAO.deleteBoard(vo);
	    	
	    	// 3. 화면 네비게이션
	    	response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			String seq = request.getParameter("seq");
	    	vo.setSeq(Integer.parseInt(seq));
	    	BoardVO board = boardDAO.getBoard(vo);
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("board", board);
	    	response.sendRedirect("getBoard.jsp");
	    	
	    	
			
		} else if (path.equals("/getBoardList.do")) {
			
			System.out.println("글 목록 검색 처리");
			
			
			 
			
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			  
			// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다. HttpSession session =
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
			
			  
			 
		}

	}

}
