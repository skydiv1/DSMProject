package com.kh.w7.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;

import com.kh.w7.mypage.model.vo.MyPage;

public class MypageDao {
	private Properties prop = new Properties();

	public ArrayList<MyPage> selectList(Connection con, int clogin) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> list= null;
		
		String query = prop.getProperty("selectList");
		
		
		
		return null;
	}

}
