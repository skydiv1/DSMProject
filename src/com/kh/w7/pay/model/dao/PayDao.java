package com.kh.w7.pay.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;
import com.kh.w7.pay.model.vo.Pay;

public class PayDao {

	private Properties prop = new Properties();
	
	public PayDao() {
		
		String fileName= PayDao.class.getResource("/sql/cash/cash-query.properties").getPath();
		

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertPay(Connection con, Pay p) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPay");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, p.getMember_code());
			pstmt.setInt(2, p.getPay_price());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int selectMemberNowCash(Connection con, int memberCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int nowCash = 0;
		
		String query = prop.getProperty("selectMemberNowCash");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				nowCash = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return nowCash;
	}

	public int insertMemberCash(Connection con, Pay p) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMemberCash");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, p.getMember_code());
			pstmt.setInt(2, p.getMember_code());
			pstmt.setInt(3, p.getPay_price());
			pstmt.setInt(4, p.getPay_price());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

}
