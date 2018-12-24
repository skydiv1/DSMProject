package com.kh.w7.pay.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;
import com.kh.w7.pay.model.vo.Pay;

public class PayDao {

	private Properties prop = new Properties();
	
	public PayDao() {
		
		String fileName= PayDao.class.getResource("/sql/pay/pay-query.properties").getPath();
		

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

}
