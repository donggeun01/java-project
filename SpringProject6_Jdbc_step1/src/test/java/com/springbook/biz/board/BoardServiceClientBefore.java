package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClientBefore {
	public static void main(String[] args) {
		// 1. Spring 而⑦뀒�씠�꼫瑜� 援щ룞�븳�떎.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring 而⑦뀒�씠�꼫濡쒕��꽣 BoardServiceImpl 媛앹껜瑜� Lookup�븳�떎.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. 湲� �벑濡� 湲곕뒫 �뀒�뒪�듃
		BoardVO vo = new BoardVO();
		

		// 4. 湲� 紐⑸줉 寃��깋 湲곕뒫 �뀒�뒪�듃
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}

		// 5. Spring 而⑦뀒�씠�꼫 醫낅즺
		container.close();
	}
}