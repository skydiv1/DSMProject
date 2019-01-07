
package com.kh.w7.member.model.dao;



import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataSource;

import com.kh.w7.member.model.vo.Img;
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

				loginUser.setMemberStatus(rset.getInt("MEMBER_STATUS"));

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

	public int insertSel(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = prop.getProperty("insertSel");

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
	public int insertCon(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		int result=0;
		String query = prop.getProperty("insertCon");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqMember.getMemberId());
			pstmt.setString(2, reqMember.getMemberName());
			pstmt.setString(3, reqMember.getMemberEmail());
			pstmt.setString(4, reqMember.getMemberPwd());
			pstmt.setString(5, reqMember.getMemberPhone());
			
			
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
		int result=0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String query = prop.getProperty("idCheck");

		try {
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt(1);
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			close(con);
		}
		
		return result;
		
		
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
	/*public  String findPwd (String id, String name, String email){
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
		 }*/
	 public int updateMember(Connection con,Member reqMember){
	        
	        
	        PreparedStatement pstmt = null;
	        
	        int result =0;
	        String query= prop.getProperty("updateMember");
	        System.out.println("query : " + query);
	 
	        try {
	            
	            pstmt = con.prepareStatement(query);
	 
	            
				pstmt.setString(1, reqMember.getMemberPwd());
				pstmt.setString(2, reqMember.getMemberName());
				pstmt.setString(3, reqMember.getMemberPhone());
				pstmt.setString(4, reqMember.getMemberEmail());
				pstmt.setString(5, reqMember.getSellerIntroduction());
				pstmt.setString(6, reqMember.getSellerCareer());
				pstmt.setString(7, reqMember.getMemberId());
				
				
				
				System.out.println(reqMember.getMemberPwd());
				System.out.println(reqMember.getMemberName());
				System.out.println(reqMember.getMemberPhone());
				System.out.println(reqMember.getMemberEmail());
				System.out.println(reqMember.getSellerIntroduction());
				System.out.println(reqMember.getSellerCareer());
				System.out.println(reqMember.getMemberId());
				
				result = pstmt.executeUpdate();
	            
	                        
	        } catch (Exception e) {
	           e.printStackTrace();
	        } finally {
	        	  close(pstmt);
					
	            }
	        
			return result;
	    }

	public int leaveMember(Connection con, int memberCode) {
		Connection conn = null;
        PreparedStatement pstmt = null;
        
        int result =0;
        String query= prop.getProperty("leaveMember");
 
        try {
            
            pstmt = conn.prepareStatement(query);
 
            
            pstmt.setInt(1, memberCode);
			
           result= pstmt.executeUpdate();
            
                        
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
        	  close(pstmt);
				
            }
        
		return result;
    }

	public String findid(Connection con, String memberName, String memberEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String memberId="";
		
		String query = prop.getProperty("findID");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberEmail);
			
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberId = rset.getString("MEMBER_ID");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return memberId;
	}

	public int findpwd(Connection con, String memberName, String memberId, String memberEmail, String randomCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("findPWD");
		
		System.out.println("query : " + query);
	
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, randomCode);
			pstmt.setString(2, memberName);
			pstmt.setString(3, memberId);
			pstmt.setString(4, memberEmail);
			/*System.out.println(memberId);
			System.out.println(memberEmail);
			System.out.println(randomCode);*/
			
			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			System.out.println("Dao result : " + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	public int insertImg(Connection con, ArrayList<Img> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertImg");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(2, "Y");
				pstmt.setString(3, fileList.get(i).getOriginname());
				pstmt.setString(4, fileList.get(i).getChangename());
				pstmt.setString(1, fileList.get(i).getSellercert_name());
				pstmt.setInt(6, fileList.get(i).getMember_code());
				pstmt.setString(5, fileList.get(i).getImg_filepath());
				
				
				result += pstmt.executeUpdate();
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}
	

	public int findmemberCode(Connection con, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int memberCode=0;
		
		String query = prop.getProperty("findmemberCode");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberCode = rset.getInt("MEMBER_CODE");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return memberCode;
	}

	
	
}




