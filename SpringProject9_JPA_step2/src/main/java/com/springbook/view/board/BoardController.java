package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("conditionMap")
	public Map<String,  String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	// getBoardList 컨트롤러
			@RequestMapping("/getBoardList.do")
			public String getBoardList(BoardVO vo, Model model, @RequestParam(value="searchCondition",defaultValue="TITLE",
									 required=false) String condition, @RequestParam(value = "searchKeyword", defaultValue="", 
									 required = false)String keyword) {
				
				if (vo.getSearchCondition() == null)  vo.setSearchCondition("TITLE");
				if (vo.getSearchKeyword() == null) 	  vo.setSearchKeyword("");
				System.out.println("어노테이션 getBoardListController 작동");
				System.out.println("검색 조건 : " + condition);
				System.out.println("검색 단어 : " + keyword);
				model.addAttribute("boardList", boardService.getBoardList(vo));
				return "getBoardList.jsp";
			}
		
		
		// insert 컨트롤러
		@RequestMapping("/insertBoard.do")
		public String insert(BoardVO vo) {

			System.out.println("어노테이션 insertBoardController 작동");
			
			boardService.insertBoard(vo);
	    	return "getBoardList.do";
	    	
		}
		
		// delete 컨트롤러
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo) {

			System.out.println("어노테이션 deleteController 작동");
		    
			boardService.deleteBoard(vo);
	    	
	    	return "getBoardList.do";
		}
		
		// update 컨트롤러
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo) {
			System.out.println("어노테이션 updateController 작동");
			System.out.println("번호  : " + vo.getSeq());
			System.out.println("작성자 : " + vo.getWriter());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("내용 : " + vo.getContent());
			System.out.println("등록일 : " + vo.getRegDate());
			System.out.println("조회수 : " + vo.getCnt());

			boardService.updateBoard(vo);
	    	
	    
	    	return "getBoardList.do";
		}
		
		
		
			
		// getBoard 컨트롤러
		@RequestMapping("/getBoard.do") 
		public String getBoardBoard (BoardVO vo, Model model) {
					
			System.out.println("어노테이션 getBoardController 작동");
	    	
	    	model.addAttribute("board", boardService.getBoard(vo));
	    	
	    	return "getBoard.jsp";
		}
		
		
		
		
	}
