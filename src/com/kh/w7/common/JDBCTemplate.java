package com.kh.w7.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		Properties prop = new Properties();
		
		// JDBCTemplate.class.getResource : src
		// getPath() : �떎�젣 寃쎈줈瑜� 臾몄옄�뿴濡� 由ы꽩
		String fileName = JDBCTemplate.class.getResource("/sql/driver.properties").getPath();
		System.out.println(fileName); // �떎�젣 �뙆�씪 �쐞移� 異쒕젰: /D:/Servlet/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/web-06/WEB-INF/classes/sql/driver.properties
		
		try {
			prop.load(new FileReader(fileName));
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			Class.forName(driver); // �뾾�뼱�룄 �룞�옉�맂�떎. (�븯�쐞踰꾩쟾�� �젣怨듯븯吏� �븡�쓬)
			con = DriverManager.getConnection(url, user, password);
			
			con.setAutoCommit(false); // �옄�룞 而ㅻ컠 諛⑹�
			
			System.out.println("connection 확인: "+con);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void commit(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void rollback(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}