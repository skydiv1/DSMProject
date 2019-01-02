package com.kh.w7.mypage.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.w7.mypage.model.vo.MyPage;

public class MypageDao {
	private static Properties prop = new Properties();
	
	public MypageDao() {
		String fileName = MypageDao.class.getResource("/sql/mypage/mypage_query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//신청목록 조회
	public ArrayList<MyPage> selectList(Connection con, int loginCode,int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> list= null;
		
		String query = prop.getProperty("myselectList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, loginCode);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
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

	//신청 목록에서 취소버튼 눌렀을때
	public int cancelUpdate(Connection con, int dealnum, String textContent) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("cancelUpdate");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, textContent);
			pstmt.setInt(2, dealnum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
	
		return result;
	}


	
	//페이징 처리
	public int getListCount(Connection con, int loginCode) {
		PreparedStatement pstmt= null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, loginCode);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return listCount;
	}

	//취소 목록 조회
	public static ArrayList<MyPage> selectCancelList(Connection con, int loginCode) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> CancelList= null;
		
		String query = prop.getProperty("CancelselectList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			CancelList = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setDealNo(rset.getInt("DEAL_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg(rset.getString("DEALLIST_ADDMESSAGE"));
				
				CancelList.add(m);
			}
			System.out.println("list값dao:"+CancelList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return CancelList;
	}

	//취소 목록에서 삭제버튼 눌렀을 때
	public int cancelDelete(Connection con, int dealnum) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("cancelDelete");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, dealnum);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
	
		return result;

	}

	//수락목록 조회
	public static ArrayList<MyPage> selectAcceptList(Connection con, int loginCode) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> appectlist= null;
		
		String query = prop.getProperty("AcceptselectList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			appectlist = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setDealNo(rset.getInt("DEAL_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg(rset.getString("DEALLIST_ADDMESSAGE"));
				
				appectlist.add(m);
			}
			System.out.println("list값dao:"+appectlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return appectlist;
	}

	//소비자 구매완료 목록 조회
	public static ArrayList<MyPage> selectDealList(Connection con, int loginCode) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> deallist= null;
		
		String query = prop.getProperty("DealselectList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			deallist = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setDealNo(rset.getInt("DEAL_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg(rset.getString("DEALLIST_ADDMESSAGE"));
				
				deallist.add(m);
			}
			System.out.println("list값dao:"+deallist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return deallist;
	}


	public static ArrayList<MyPage> selectWaitingList(Connection con, int loginCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> waitlist= null;
		
		String query = prop.getProperty("selectWaitingList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			waitlist = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setDealNo(rset.getInt("DEAL_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg(rset.getString("DEALLIST_ADDMESSAGE"));
				
				waitlist.add(m);
			}
			System.out.println("list값dao:"+waitlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return waitlist;
	}


	
}
