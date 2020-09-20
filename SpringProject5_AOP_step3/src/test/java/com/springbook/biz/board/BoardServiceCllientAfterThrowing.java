package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceCllientAfterThrowing {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContextAfterThrowing.xml");
		
		// 2. Spring 컨테이너로부터 BoardService 객체를 Lookup한다.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
						
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용 .....");
		boardService.insertBoard(vo);

	}

}
