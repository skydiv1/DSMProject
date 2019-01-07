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
		String fileName = ReplyDao
				.class
				.getResource("/sql/board/board-query.properties")
				.getPath();
			
		try {
			prop.load(new FileReader(fileName));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	public ArrayList<Reply> selectReplyList(Connection con){
		Statement stmt = null;
        ResultSet rset = null;
        ArrayList<Reply> list = null;
        String query = prop.getProperty("selectReplyList");
        Board b = new Board();
        Member m = new Member();
        Reply r = new Reply();
        
        try {
        	stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			list = new ArrayList<Reply>();
			while(rset.next()) {
				r.setReplyNo(rset.getInt("Reply_No"));
				r.setBoardNo(rset.getInt("Board_no"));
				r.setMemberCode(rset.getInt("Member_Code"));
				r.setReplyContext(rset.getString("Reply_Context"));
				r.setReplyDate(rset.getDate("Reply_Date"));
				r.setReplyDelete(rset.getInt("Reply_Delete"));
				list.add(r);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
        return list;
		
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

	
	

	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
