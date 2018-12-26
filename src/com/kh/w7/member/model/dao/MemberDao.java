
package com.kh.w7.member.model.dao;



import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.activation.DataSource;

import com.kh.w7.member.model.vo.Member;
import static com.kh.w7.common.JDBCTemplate.*;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();// getPath는
																										// String으로
																										// 바꿔준다는 뜻

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member logincheck(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null; // 조회결과를 담을 곳
		Member loginUser = null;

		String query = prop.getProperty("loginSelect");

		try {

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, reqMember.getMemberId());

			pstmt.setString(2, reqMember.getMemberPwd());

			rset = pstmt.executeQuery();

			if (rset.next()) {

				loginUser = new Member();

				loginUser.setMemberCode(rset.getInt("MEMBER_CODE"));

				loginUser.setMemberId(rset.getString("MEMBER_ID"));

				loginUser.setMemberPwd(rset.getString("MEMBER_PWD"));

				loginUser.setMemberName(rset.getString("MEMBER_NAME"));

				loginUser.setMemberPhone(rset.getString("MEMBER_PHONE"));

				loginUser.setMemberEmail(rset.getString("MEMBER_EMAIL"));

				loginUser.setMemberCategory(rset.getInt("MEMBER_CATEGORY"));

				loginUser.setSellerIntroduction(rset.getString("SELLER_INTRODUCTION"));

				loginUser.setSellerGrade(rset.getInt("SELLER_GRADE"));

				loginUser.setMemberAdmin(rset.getInt("MEMBER_ADMIN"));

				loginUser.setPrivatememberStatus(rset.getInt("MEMBER_STATUS"));

				loginUser.setSellerAccountName(rset.getString("SELLER_ACCOUNTNAME"));

				loginUser.setSellerBank(rset.getString("SELLER_BANK"));

				loginUser.setSellerAccount(rset.getString("SELLER_ACCOUNT"));

				loginUser.setSellerCareer(rset.getString("SELLER_CAREER"));

				loginUser.setSellerCertcheck(rset.getInt("SELLER_CERTCHECK"));
			

			}
			System.out.println("loginUser(확인): " + loginUser);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return loginUser;
	}

	public int insertMember(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqMember.getMemberId());
			pstmt.setString(2, reqMember.getMemberName());
			pstmt.setString(3, reqMember.getMemberEmail());
			pstmt.setString(4, reqMember.getMemberPwd());
			pstmt.setString(5, reqMember.getMemberPhone());
			pstmt.setString(6, reqMember.getSellerIntroduction());
			pstmt.setString(7, reqMember.getSellerCareer());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 아이디 중복 검사
	public int idCheck(Connection con, String memberId) {
		
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("idCheck");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			

			if (rset.next()|| memberId.equals("")) {
				return 0;//이미가입
				
			}else {
				return 1;//가입가능
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			close(con);
		}

		return -1;//오류
		
	}

	public int changeMember(Connection con, Member reqMember) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String findId (String name, String email){
		  String memberId = null;
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rset = null;
		  String query = prop.getProperty("findID");
		  try{
		   
		   pstmt = conn.prepareStatement(query);
		   pstmt.setString(1,name);
		   pstmt.setString(2, email);
		   
		   rset = pstmt.executeQuery();
		   while(rset.next()){
		    memberId = rset.getString("memberId");
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally{
			  close(pstmt);
				close(rset);
		  }
		  return memberId;
		 }
	public  String findPwd (String id, String name, String email){
		  String memberPwd = null;
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rset = null;
		  String query = prop.getProperty("findPWD");
		  try{
		   
		   pstmt = conn.prepareStatement(query);
		   pstmt.setString(1,id);
		   pstmt.setString(2,name);
		   pstmt.setString(3, email);
		   
		   rset = pstmt.executeQuery();
		   while(rset.next()){
		    memberPwd = rset.getString("memberPwd");
		   }
		  }catch(Exception e){
		   e.printStackTrace();
		  }finally{
			  close(pstmt);
				close(rset);
		  }
		  return memberPwd;
		 }

}
