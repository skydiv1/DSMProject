
package com.kh.w7.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.w7.member.model.vo.Member;
import static com.kh.w7.common.JDBCTemplate.*;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
	String fileName= MemberDao.class.getResource("/sql/member/member-query.properties").getPath();//getPath는 String으로 바꿔준다는 뜻
	

			try {
				prop.load(new FileReader(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public Member logincheck(Connection con, Member reqMember) {
		PreparedStatement pstmt= null;
		ResultSet rset= null; //조회결과를 담을 곳
		Member loginUser = null;
		
		String query= prop.getProperty("loginSelect");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, reqMember.getMember_id());
			pstmt.setString(2, reqMember.getMember_pwd());
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser=new Member();
				
				loginUser.setMember_code(rset.getInt("MEMBER_CODE"));
				loginUser.setMember_id(rset.getString("MEMBER_ID"));
				loginUser.setMember_pwd(rset.getString("MEMBER_PWD"));
				loginUser.setMember_name(rset.getString("MEMBER_NAME"));
				loginUser.setMember_phone(rset.getString("MEMBER_PHONE"));
				loginUser.setMember_email(rset.getString("MEMBER_EMAIL"));
				loginUser.setMember_category(rset.getInt("MEMBER_CATEGORY"));
				loginUser.setSeller_introduction(rset.getString("SELLER_INTRODUCTION"));
				loginUser.setSeller_grade(rset.getInt("SELLER_GRADE"));
				loginUser.setSeller_career(rset.getString("SELLER_CAREER"));
				loginUser.setMember_admin(rset.getInt("MEMBER_ADMIN"));
				loginUser.setPrivatemember_status(rset.getInt("MEMBER_STATUS"));
				loginUser.setSeller_accountName(rset.getString("SELLER_ACCOUNTNAME"));
				loginUser.setSeller_bank(rset.getString("SELLER_BANK"));
				loginUser.setSeller_account(rset.getString("SELLER_ACCOUNT"));
			
			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return loginUser;
	}

	

	public int insertMember(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = prop.getProperty("insertMember");
		
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, reqMember.getMember_id());
			pstmt.setString(1, reqMember.getMember_pwd());
			pstmt.setString(1, reqMember.getMember_name());
			pstmt.setString(1, reqMember.getMember_phone());
			pstmt.setString(1, reqMember.getMember_email());
			pstmt.setString(1, reqMember.getSeller_introduction());
			pstmt.setString(1, reqMember.getSeller_career());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	//아이디 중복 검사
	public int idCheck(Connection con, String inputId) {
		int result=0;
		
		PreparedStatement pstmt =null;
		ResultSet rset= null;
		
		String query =prop.getProperty("idCheck");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return result;
	}

}
