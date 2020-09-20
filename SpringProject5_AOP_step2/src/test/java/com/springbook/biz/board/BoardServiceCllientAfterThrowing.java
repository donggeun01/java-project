package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceCllientAfterThrowing {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContextAfterThrowing.xml");
		
		// 2. Spring 而⑦뀒�씠�꼫濡쒕��꽣 BoardService 媛앹껜瑜� Lookup�븳�떎.
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// 3. 湲� �벑濡� 湲곕뒫 �뀒�뒪�듃
		BoardVO vo = new BoardVO();
						
		vo.setTitle("홍길동");
		vo.setWriter("임시");
		vo.setContent("임시내용 .......");
		boardService.insertBoard(vo);

	}

}
