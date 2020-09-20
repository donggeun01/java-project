package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceCllientBefore {

	public static void main(String[] args) {
	
				AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContextBefore.xml");
				
				// 2. Spring 컨테이너로부터 BoardService 객체를 Lookup한다.
				BoardService boardService = (BoardService) container.getBean("boardService");
				
				// 3. 글 등록 기능 테스트
				BoardVO vo = new BoardVO();
								
				// 4. 글 목록 검색 기능 테스트
				List<BoardVO> boardList = boardService.getBoardList(vo);
				for(BoardVO board : boardList) {
					System.out.println("--->" + board.toString());
				}
				
	}

}
 