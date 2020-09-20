package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController{


		@RequestMapping("/getBoard.do") 
		public ModelAndView getBoardBoard (BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
					
			System.out.println("어노테이션 getBoardController 작동");
	    	
	    	mav.addObject("board", boardDAO.getBoard(vo));
	    	mav.setViewName("getBoard");
	    	
	    	return mav;
		}

    	

}
