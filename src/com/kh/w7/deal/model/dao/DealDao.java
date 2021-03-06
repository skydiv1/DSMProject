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
	
	
	public ArrayList<Deal> selectOneProduct(Connection con, int memberCode, int productNo, int dealnum) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Deal d = null;
		ArrayList<Deal> list = new ArrayList<Deal>();
		
		String query = prop.getProperty("selectOneProduct");
		//쿼리문 작성 후, 하단 코드 마무리
		try {
			pstmt = con.prepareStatement(query);
			/*pstmt.setInt(1, memberCode);
			pstmt.setInt(2, productNo);*/
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, memberCode);
			pstmt.setInt(3, memberCode);
			pstmt.setInt(4, productNo);
			pstmt.setInt(5, memberCode);
			pstmt.setInt(6, productNo);
			
			rset = pstmt.executeQuery(); //여기서 오류 발생
			
			
			while(rset.next()) {
				d = new Deal();

				//쿼리문 select모양에 맞게 뽑아오기
				//d.setDealNo(rset.getInt(1));
				d.setDealNo(dealnum);
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
				d.setChangedImgName(rset.getString(13));
				
				list.add(d);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		//System.out.println("DaoList : "+list);
		
		return list;
	}


	public int updateCashDeal(Connection con, int dealNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCashDeal");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, dealNo);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateCustomerCash(Connection con, int customerCode, int dealNo, int totalPrice, int nowCash) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCustomerCash");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, customerCode); //맴버코드
			pstmt.setInt(2, nowCash-totalPrice); //맴버 현재캐쉬 (소비자는 돈을 소비하고 상품을 구매하니 -)
			pstmt.setInt(3, dealNo); //거래번호
			pstmt.setInt(4, totalPrice); //거래금액
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	public int updateSellerCash(Connection con, int sellerCode, int dealNo, int totalPrice, int nowCash) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateSellerCash");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sellerCode); //맴버코드
			pstmt.setInt(2, nowCash+totalPrice); //맴버 현재캐쉬 (판매자는 거래시 돈을 버니 +)
			pstmt.setInt(3, dealNo); //거래번호
			pstmt.setInt(4, totalPrice); //거래금액
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