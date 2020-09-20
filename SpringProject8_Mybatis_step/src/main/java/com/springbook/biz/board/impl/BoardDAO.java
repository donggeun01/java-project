package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.util.SqlSessionFactoryBean;
 

@Repository("boardDAO")
public class BoardDAO {

	private SqlSession mybatis;
	
	public BoardDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);	// BoardDAO = 네임스페이스 , insertBoard = id
		mybatis.commit();
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
		mybatis.commit();
	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
		mybatis.commit();
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("보더리스트 실행");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
	public BoardVO getBoard (BoardVO vo) {
		return mybatis.selectOne("BoardDAO.getBoard", vo);
	}

}
