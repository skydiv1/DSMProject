package com.kh.w7.reply.model.dao;

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
import com.kh.w7.reply.model.*;
import com.kh.w7.reply.model.vo.Reply;

import oracle.net.aso.b;


public class ReplyDao {
	private Properties prop = new Properties();
	private static String selectSEQ = "SELECT SEQ_BOARD.NEXTVAL FROM DUAL";
	
	
	
	public ReplyDao() {
		String fileName = ReplyDao.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	

	public int insertReply(Connection con, Reply r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, r.getBoardNo());
			pstmt.setInt(2, r.getMemberCode());
			pstmt.setString(3, r.getReplyContext());
			
			System.out.println(r.getBoardNo());
			System.out.println(r.getMemberCode());
			System.out.println(r.getReplyContext());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
	
		return result;
	}

	public ArrayList<Reply> selectReplyList(Connection con, int boardNo ) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Reply>();
			
			while(rset.next()) {
				Reply r = new Reply();
				r.setReplyNo(rset.getInt("REPLY_NO"));
				r.setBoardNo(rset.getInt("BOARD_NO"));
				r.setMemberCode(rset.getInt("MEMBER_CODE"));
				r.setReplyContext(rset.getString("REPLY_CONTEXT"));
				r.setReplyDate(rset.getDate("REPLY_DATE"));
				r.setReplyDelete(rset.getInt("REPLY_DELETE"));
				list.add(r);
				
		
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



	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
