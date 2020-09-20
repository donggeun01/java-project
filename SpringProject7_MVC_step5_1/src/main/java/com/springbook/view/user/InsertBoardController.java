package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{


		@RequestMapping("/insertBoard.do")
		public String insert(BoardVO vo, BoardDAO boardDAO) {

			System.out.println("어노테이션 insertBoardController 작동");
			
	    	boardDAO.insertBoard(vo);
	    	return "redirect:getBoardList.do";
	    	
		}
    	
	

}
