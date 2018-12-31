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
import com.kh.w7.common.Attachment;
import com.kh.w7.member.model.vo.Member;

import oracle.net.aso.b;


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
		Board b = new Board();		
		Member m = new Member();
		
		
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Board>();
			
			while(rset.next()) {
								
				b.setBoardNo(rset.getInt("BOARD_NO"));
				m.setMemberName(rset.getString("MEMBER_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContext(rset.getString("BOARD_CONTEXT"));
				b.setBoardDate(rset.getDate("BOARD_DATE"));
				b.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				b.setBoardCount(rset.getInt("BOARD_COUNT"));
				b.setBoardDelete(rset.getInt("BOARD_DELETE"));
				
				list.add(b);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
			
		}
		
		return list;
		
		
	}

	public int insertBoard(Connection con, Board insertBoard) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);			
			pstmt.setInt(1, insertBoard.getMemberCode());
			pstmt.setString(2, insertBoard.getBoardTitle());
			pstmt.setString(3, insertBoard.getBoardContext());	

			
			System.out.println(insertBoard);
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
			
			System.out.println("startRow : " + startRow);
			System.out.println("endRow : " + endRow);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();

			list = new ArrayList<Board>();
			
			Member m = new Member(); 
			
			
			while(rset.next()) {			
				Board b = new Board();			  
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				/*b.setMemberCode(rset.getInt("MEMBER_CODE"));*/
				b.setMemberName(rset.getString("MEMBER_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContext(rset.getString("BOARD_CONTEXT"));
				b.setBoardDate(rset.getDate(6));
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

	public int updateCount(Connection con, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public Board selectOne(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		
		
		String query = prop.getProperty("selectOne");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
		
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setMemberName(rset.getString("MEMBER_NAME"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContext(rset.getString("BOARD_CONTEXT"));
				b.setBoardDate(rset.getDate("BOARD_DATE"));
				b.setBoardCategory(rset.getInt("BOARD_CATEGORY"));
				b.setBoardCount(rset.getInt("BOARD_COUNT"));
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
	
	/* 현재 시퀀스 값 조회 */
	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset =null;
		
		int boardNo=0;
		
		String query = prop.getProperty("selectCurrval"); // 현재 동작한 시퀀스 번호를 알 수 있다.
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				boardNo = rset.getInt("CURRVAL");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt); // Connection을 닫으면 안된다. service에서 트랜젝션 처리를 해 줄 수 없다
		}
		
		return boardNo;
	}	

	
	/* 다음 시퀀스 조회 */
	public int selectNextval(Connection con) {
		Statement stmt = null;
		ResultSet rset =null;
		
		int boardNo=0;
		
		String query = prop.getProperty("selectNextval"); // 현재 동작한 시퀀스 번호를 알 수 있다.
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				boardNo = rset.getInt("NEXTVAL");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt); // Connection을 닫으면 안된다. service에서 트랜젝션 처리를 해 줄 수 없다
		}
		
		return boardNo;
	}

	public int updateBoard(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContext());
			pstmt.setInt(3, b.getBoardNo());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int insertAttachment(Connection con, ArrayList<Attachment> boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
