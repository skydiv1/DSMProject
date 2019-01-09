
package com.kh.w7.member.model.dao;



import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataSource;

import com.kh.w7.common.Attachment;
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

            loginUser.setMemberCode(rset.getInt(1));

            loginUser.setMemberId(rset.getString(2));

            loginUser.setMemberPwd(rset.getString(3));

            loginUser.setMemberName(rset.getString(4));

            loginUser.setMemberPhone(rset.getString(5));

            loginUser.setMemberEmail(rset.getString(6));

            loginUser.setMemberCategory(rset.getInt(7));

            loginUser.setSellerIntroduction(rset.getString(8));

            loginUser.setSellerGrade(rset.getInt(9));

            loginUser.setMemberAdmin(rset.getInt(10));

            loginUser.setMemberStatus(rset.getInt(11));

            loginUser.setSellerAccountName(rset.getString(12));

            loginUser.setSellerBank(rset.getString(13));

            loginUser.setSellerAccount(rset.getString(14));

            loginUser.setSellerCareer(rset.getString(15));

            loginUser.setSellerCertcheck(rset.getInt(16));
         
            loginUser.setBlackCount(rset.getInt(17));
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
        PreparedStatement pstmt = null;
        
        int result =0;
        String query= prop.getProperty("leaveMember");
 
        try {
            
            pstmt = con.prepareStatement(query);
            System.out.println(query);
            
            pstmt.setInt(1, memberCode);
         
           result= pstmt.executeUpdate();
            System.out.println("dao resut: "+result);
                        
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


   public int insertImg(Connection con, ArrayList<Attachment> fileList) {
      PreparedStatement pstmt = null;
      int result = 0;
      
      String query = prop.getProperty("insertImg");
      
      try {
         for(int i = 0; i < fileList.size(); i++) {
            pstmt = con.prepareStatement(query);
            
            
            pstmt.setString(1, fileList.get(i).getOriginName());
            pstmt.setString(2, fileList.get(i).getChangeName());
            pstmt.setString(3, fileList.get(i).getSellerCertName());
            pstmt.setInt(4, fileList.get(i).getMemberCode());
            pstmt.setString(5, fileList.get(i).getChangeName());
            
            
            result += pstmt.executeUpdate();
   
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         close(pstmt);
      }

      return result;
   }
   

   public int findmemberCode(Connection con, Member reqMember) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      int memberCode=0;
      
      String query = prop.getProperty("findmemberCode");
      
      try {
         pstmt = con.prepareStatement(query);
//         pstmt.setMember(1, reqMember);
         
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


   public int insertMemberCash(Connection con, Member reqMember) {
      // TODO Auto-generated method stub
      PreparedStatement pstmt = null;
      int result = 0;
      
      String query = prop.getProperty("insertMemberCash");
      
      try {
         pstmt = con.prepareStatement(query);
         result = pstmt.executeUpdate();
         
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         close(pstmt);
      }
   }

   /* 현재 시퀀스값 조회 */
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

   
   /* 이미지 추가(insert) */
   public int insertAttachment(Connection con, ArrayList<Attachment> fileList) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = prop.getProperty("insertAttachment");
      
      
      try {
         for(int i=0; i<fileList.size(); i++) {
            pstmt = con.prepareStatement(query);
            //pstmt.setInt(1, fileList.get(i).getImgNo());
            pstmt.setString(1, fileList.get(i).getOriginName());
            pstmt.setString(2, fileList.get(i).getChangeName());
//            pstmt.setInt(3, fileList.get(i).getMemberCode());
            //pstmt.setInt(4, fileList.get(i).getProductNo()); // IMG_FK2

            int level = 0;
            if(i==0) level=0;
            else level=1;
            pstmt.setInt(3, level);
            pstmt.setString(4, fileList.get(i).getImgFilePath());
            
            result += pstmt.executeUpdate(); // 누적 연산으로 합쳐준다
            
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      System.out.println("insertAttachment(result값): "+result);
      
      return result;
   }

}
   
   



