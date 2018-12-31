package com.kh.w7.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;
import com.kh.w7.pay.model.dao.PayDao;
import com.kh.w7.refund.model.vo.Refund;

public class AdminDao {
	
	private Properties prop = new Properties();
	
	public AdminDao() {
		
		String fileName= AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Refund> SelectAllRefundMember(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Refund r = null;
		ArrayList<Refund> list = new ArrayList<Refund>();
		
		String query = prop.getProperty("SelectAllRefundMember");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Refund();
				r.setRefund_no(rset.getInt(1));
				r.setMember_name(rset.getString(2));
				r.setRefund_bank(rset.getString(3));
				r.setRefund_account(rset.getString(4));
				r.setMember_birth(rset.getString(5));
				r.setRefund_money(rset.getInt(6));
				r.setRefund_applyDate(rset.getDate(7));
				r.setRefund_StatusYN(rset.getInt(8));
				
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
