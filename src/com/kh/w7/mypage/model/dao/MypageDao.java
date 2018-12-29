package com.kh.w7.mypage.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;

import com.kh.w7.mypage.model.vo.MyPage;

public class MypageDao {
	private Properties prop = new Properties();
	
	public MypageDao() {
		String fileName = MypageDao.class.getResource("/sql/mypage/mypage_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<MyPage> selectList(Connection con, int loginCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> list= null;
		
		String query = prop.getProperty("myselectList");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			list = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setDealNo(rset.getInt("DEAL_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg(rset.getString("DEALLIST_ADDMESSAGE"));
				
				list.add(m);
			}
			System.out.println("list값dao:"+list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return list;
	}


	public int cancelUpdate(Connection con, int loginCode, int no, String textContent) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("cancelUpdate");
		
	
		return 0;
	}


	
}
