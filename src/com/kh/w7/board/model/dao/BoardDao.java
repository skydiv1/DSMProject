package com.kh.w7.board.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.w7.board.model.vo.Board;
import com.kh.w7.member.model.vo.Member;


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
		String query = prop.getProperty("selectList");
		Board b = null;
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
				b.setBoardCount(rset.getInt("BOARD_COUNT"));
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
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			/*pstmt.setInt(1, b.getMemberCode());*/
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContext());
			pstmt.setInt(3, b.getMemberCode());
			pstmt.setDate(4, b.getBoardDate());
			
			System.out.println(b);
			result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
		
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board();
				
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMemberCode(rset.getInt("MEMBER_CODE"));	
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContext(rset.getString("BOARD_CONTEXT"));
				b.setBoardDate(rset.getDate("BOADR_DATE"));
				b.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				b.setBoardCount(rset.getInt("BOARD_COUNT"));
				b.setBoardDelete(rset.getInt("BOARD_DELETE"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
	
		
		return list;
	}

	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(stmt);
			close(rset);
		}
		
		
		
		return listCount;
	}

	public int updateCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public Board selectOne(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMemberCode(rset.getInt("MEMBER_CODE"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContext(rset.getString("BOARD_CONTEXT"));
				b.setBoardDate(rset.getDate("BOADR_DATE"));
				b.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				b.setBoardDelete(rset.getInt("BOARD_DELETE"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return b;
	}

	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
