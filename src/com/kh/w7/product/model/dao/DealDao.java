package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.w7.deal.model.vo.Deal;

public class DealDao {
		private Properties prop = new Properties();
		
		public DealDao() {
			String fileName = DealDao.class.getResource("/sql/product/deal-query.properties").getPath();
			
			try {
				prop.load(new FileReader(fileName));
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public int insertDeal(Connection con, Deal deal) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertDeal");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);			
			pstmt.setInt(1, deal.getProductNo());
			pstmt.setInt(2, deal.getCustomerCode());
			pstmt.setInt(3, deal.getSellerCode());	
			pstmt.setInt(4, deal.getMainProductPrice());	
									
			result = pstmt.executeUpdate();
			System.out.println("deal(DAO) : "+deal);
			System.out.println("result(insertDeal(DAO)) : "+result);
			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
