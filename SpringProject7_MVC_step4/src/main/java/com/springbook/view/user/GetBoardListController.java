package com.springbook.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�� ��� �˻� ó�� MVC�����ӿ�ũ");
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		  
		// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�. HttpSession session =
//		HttpSession session = request.getSession();
//		
//		session.setAttribute("boardList", boardList);
//		
//		return "getBoardList";
		
		
		// 3. �˻� ��� ȭ�� ������ ModelAndView�� �����Ͽ� �����Ѵ�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
	}
	
}
