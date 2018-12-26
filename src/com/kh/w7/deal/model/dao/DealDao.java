package com.kh.w7.deal.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;
import com.kh.w7.deal.model.vo.Deal;
import com.kh.w7.pay.model.dao.PayDao;

public class DealDao {

	private Properties prop = new Properties();
	
	public DealDao() {
		String fileName= PayDao.class.getResource("/sql/cash/cash-query.properties").getPath();
		

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Deal> selectOneProduct(Connection con, int memberCode, int productNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Deal d = null;
		ArrayList<Deal> list = new ArrayList<Deal>();
		
		String query = prop.getProperty("selectOneProduct");
		//쿼리문 작성 후, 하단 코드 마무리
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			pstmt.setInt(2, productNo);
			
			rset = pstmt.executeQuery(); //여기서 오류 발생
			
			
			while(rset.next()) {
				d = new Deal();

				//쿼리문 select모양에 맞게 뽑아오기
				d.setDealNo(rset.getInt(1));
				d.setProductNo(rset.getInt(2));
				d.setImgFilePath(rset.getString(3));
				d.setProductTitle(rset.getString(4));
				d.setProductContext(rset.getString(5));
				d.setCustomerCode(rset.getInt(6));
				d.setSellerCode(rset.getInt(7));
				d.setMainProductName(rset.getString(8));
				d.setMainProductPrice(rset.getInt(9));
				d.setSubProductName(rset.getString(10));
				d.setSubProductPrice(rset.getInt(11));
				d.setMemberNowCash(rset.getInt(12));
				
				list.add(d);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		System.out.println("DaoList : "+list);
		
		return list;
	}

}
