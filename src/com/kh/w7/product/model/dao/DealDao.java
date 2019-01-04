package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.kh.w7.deal.model.vo.Deal;
import com.kh.w7.deal.model.vo.DealList;

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

	public int insertDealList(Connection con, DealList dealList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertDealList");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);			
			//pstmt.setInt(1, dealList.getDealNo());
			pstmt.setString(1, dealList.getAddmessage1());
									
			result = pstmt.executeUpdate();
			System.out.println("dealList(DAO) : "+dealList);
			System.out.println("result(insertDeal(DAO)) : "+result);
			
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	/* 현재 시퀀스 값 조회 */
	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset =null;
		
		int currNum=0;
		
		String query = prop.getProperty("selectCurrval"); // 현재 동작한 시퀀스 번호를 알 수 있다.
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				currNum = rset.getInt("CURRVAL");
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt); // Connection을 닫으면 안된다. service에서 트랜젝션 처리를 해 줄 수 없다
		}
		
		return currNum;
	}

	
	public int selectNextval(Connection con) {
		Statement stmt = null;
		ResultSet rset =null;
		
		int currNum=0;
		
		String query = prop.getProperty("selectNextval"); // 현재 동작한 시퀀스 번호를 알 수 있다.
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				currNum = rset.getInt("NEXTVAL");
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt); // Connection을 닫으면 안된다. service에서 트랜젝션 처리를 해 줄 수 없다
		}
		
		return currNum;
	}

}
