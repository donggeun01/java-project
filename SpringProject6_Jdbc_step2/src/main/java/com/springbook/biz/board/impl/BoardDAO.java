package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
 

@Repository("boardDAO")
public class BoardDAO extends JdbcDaoSupport {
	// JDBC 愿��젴蹂��닔
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL 紐낅졊�뼱�뱾
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?,content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET = "select * from board where seq=?";
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	@Autowired
	public void setSuperDataSoure(DataSource dataSource) {
			super.setDataSource(dataSource);
		}
	
	// CRUD 湲곕뒫�쓽 硫붿냼�뱶 援ы쁽
	// 湲� �벑濡�
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능처리");
		getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		
	}
	
	// 湲� �닔�젙
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능처리");
		getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 湲� �궘�젣
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능처리");
		getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
	}
	
	// 湲� �긽�꽭 議고쉶
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능처리");
		Object[] args = {vo.getSeq()};
		return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
		
	}
	
	// 湲� 紐⑸줉 議고쉶
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능처리");
		return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
	}

}


class BoardRowMapper implements RowMapper<BoardVO> {
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	
	}	
		
	
}