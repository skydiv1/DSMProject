
package com.kh.w7.member.model.dao;



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
			pstmt.setString(1, reqMember.getMemberPwd());
			pstmt.setString(1, reqMember.getMemberName());
			pstmt.setString(1, reqMember.getMemberPhone());
			pstmt.setString(1, reqMember.getMemberEmail());
			pstmt.setString(1, reqMember.getSellerIntroduction());
			pstmt.setString(1, reqMember.getSellerCareer());

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
	public int idCheck(Connection con, String inputId) {
		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("idCheck");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, inputId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return result;
	}

	public int changeMember(Connection con, Member reqMember) {
		// TODO Auto-generated method stub
		return 0;
	}

}
