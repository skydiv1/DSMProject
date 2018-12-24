package com.kh.w7.board.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.w7.board.model.vo.Board;
import com.kh.w7.common.Attachment;


public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public ArrayList<Board> selectList(Connection con){
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		Board b = null;
		String query = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				b = new Board();
				
				if(b.getBoardCategory() == 0) {
				
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMemberCode(rset.getInt("MEMBER_CODE"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContext(rset.getString("BOARD_CONTEXT"));
				b.setBoardDate(rset.getDate("BOADR_DATE"));
				b.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				b.setBoardDelete(rset.getInt("BOARD_DELETE"));
				
				list.add(b);
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
			
		}
		
		return list;
		
		
	}

	public int insertBoard(Connection con, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getListCount(Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateCount(Connection con, int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Board selectOne(Connection con, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertReply(Connection con, Board b) {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
