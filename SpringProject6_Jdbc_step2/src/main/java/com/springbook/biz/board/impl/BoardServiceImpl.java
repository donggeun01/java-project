package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;


@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO2 boardDAO;
	

	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getSeq() == 0) { throw new
//			IllegalArgumentException("0踰� 湲��� �벑濡앺븷 �닔 �뾾�뒿�땲�떎."); }
		boardDAO.insertBoard(vo);
		boardDAO.insertBoard(vo);		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		
		boardDAO.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		
		boardDAO.deleteBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return boardDAO.getBoardList(vo);
	}
	
	
	
	
	

}
