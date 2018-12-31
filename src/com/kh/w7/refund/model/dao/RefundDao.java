package com.kh.w7.refund.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;
import com.kh.w7.pay.model.dao.PayDao;
import com.kh.w7.refund.model.vo.Refund;

public class RefundDao {

	private Properties prop = new Properties();
	
	public RefundDao() {
		
		String fileName= PayDao.class.getResource("/sql/cash/cash-query.properties").getPath();
		

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int insertRefundData(Connection con, Refund r) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertRefundData");
		
		System.out.println(r);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, r.getMember_code());
			pstmt.setInt(2, r.getRefund_money());
			pstmt.setString(3, r.getMember_name());
			pstmt.setString(4, r.getMember_birth());
			pstmt.setString(5, r.getRefund_bank());
			pstmt.setString(6, r.getRefund_account());	
			result = pstmt.executeUpdate(); //여기서 안내려감
			
			
			//System.out.println("dao result : " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertRefundListData(Connection con, Refund r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertRefundListData");
		try {
			pstmt = con.prepareStatement(query);

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int insertMemberCashRefundData(Connection con, Refund r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMemberCashRefundData");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, r.getMember_code());
			pstmt.setInt(2, r.getMember_code());
			pstmt.setInt(3, r.getRefund_money());
			pstmt.setInt(4, r.getRefund_money());
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
