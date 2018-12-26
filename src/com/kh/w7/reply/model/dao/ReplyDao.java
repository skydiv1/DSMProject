package com.kh.w7.reply.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.w7.reply.model.vo.Reply;

public class ReplyDao {
	
	private Properties prop = new Properties();
	
	public int insertReply(Connection con, Reply r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, r.getMemberCode());
			pstmt.setString(2, r.getReplyContext());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Reply> selectReplyList(Connection con, int replyNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, replyNo);
			
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
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

}


