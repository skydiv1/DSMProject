package com.kh.w7.mypage.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.w7.mypage.model.vo.MyPage;
import com.kh.w7.product.model.vo.Product;
import com.kh.w7.refund.model.vo.Refund;

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
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				
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
	public ArrayList<MyPage> selectCancelList(Connection con, int loginCode) {

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
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				m.setDealListaddMsg2(rset.getString("DEALLIST_ADDMESSAGE2"));
				
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
	public ArrayList<MyPage> selectAcceptList(Connection con, int loginCode) {

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
				m.setProductNo(rset.getInt("PRODUCT_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				m.setDealListaddMsg2(rset.getString("DEALLIST_ADDMESSAGE2"));
				
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
	public ArrayList<MyPage> selectDealList(Connection con, int loginCode) {

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
				m.setProductNo(rset.getInt("PRODUCT_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				m.setDealListaddMsg2(rset.getString("DEALLIST_ADDMESSAGE2"));
				m.setDealListCategory(rset.getInt("DEALLIST_CATEGORY"));
				
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


	//판매자 대기자 목록
	public ArrayList<MyPage> selectWaitingList(Connection con, int loginCode) {
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
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				
				waitlist.add(m);
			}
			System.out.println("대기자목록 list dao:"+waitlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return waitlist;
	}

	//판매자 거절
	public int cancelUpdateseller(Connection con, int dealnum, String textContent) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("cancelUpdateseller");
		
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

	//판매자 구매진행 목록
	public ArrayList<MyPage> selectdealprogressList(Connection con, int loginCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> progresslist= null;
		
		String query = prop.getProperty("selectdealprogressList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			progresslist = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setDealNo(rset.getInt("DEAL_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				m.setDealListaddMsg2(rset.getString("DEALLIST_ADDMESSAGE2"));
				m.setDealListCategory(rset.getInt("DEALLIST_CATEGORY"));
				
				progresslist.add(m);
			}
			System.out.println("구매진행상황 list dao:"+progresslist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return progresslist;
	}

	//판매자 수락하기 버튼 누를때
	public int AgreelUpdateseller(Connection con, int dealnum, String textContent) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("AgreelUpdateseller");
		
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

	//판매자 취소목록 조회
	public ArrayList<MyPage> selectSellerCancelList(Connection con, int loginCode) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> sellerCancelList= null;
		
		String query = prop.getProperty("selectSellerCancelList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			sellerCancelList = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setDealNo(rset.getInt("DEAL_NO"));
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				m.setDealListaddMsg2(rset.getString("DEALLIST_ADDMESSAGE2"));
				
				sellerCancelList.add(m);
			}
			System.out.println("list값dao:"+sellerCancelList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return sellerCancelList;
	}

	//판매자 판매글 보기
	public ArrayList<Product> selectProductList(Connection con, int loginCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> productlist= null;
		
		String query = prop.getProperty("selectProductList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			productlist = new ArrayList<Product>();
			
			while(rset.next()) {
				Product p = new Product();
				
				p.setProductNo(rset.getInt("PRODUCT_NO"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setProductContext(rset.getString("PRODUCT_CONTEXT"));
				
				productlist.add(p);
			}
			System.out.println("list값dao:"+productlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return productlist;
	}

	//소비자 구매확정 버튼
	public int completeUpdate(Connection con, int dealnum) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("completeUpdate");
		
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

	//판매자 판매완료 목록
	public ArrayList<MyPage> selectendDealList(Connection con, int loginCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPage> endlist= null;
		
		String query = prop.getProperty("selectendDealList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			endlist = new ArrayList<MyPage>();
			
			while(rset.next()) {
				MyPage m = new MyPage();
				
				m.setMember_id(rset.getString("MEMBER_ID"));
				m.setProductName(rset.getString("PRODUCT_NAME"));
				m.setDealListaddMsg1(rset.getString("DEALLIST_ADDMESSAGE1"));
				m.setDealListCategory(rset.getInt("DEALLIST_CATEGORY"));
				endlist.add(m);
			}
			System.out.println("판매완료값dao:"+endlist);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return endlist;
	}

	//판매자 환급목록
	public ArrayList<Refund> selectCashList(Connection con, int loginCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Refund> cashlist= null;
		
		String query = prop.getProperty("selectCashList");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, loginCode);
			
			rset= pstmt.executeQuery();
			
			
			cashlist = new ArrayList<Refund>();
			
			while(rset.next()) {
				Refund r = new Refund();
				
				r.setRefund_applyDate(rset.getDate("REFUND_DATE"));
				r.setRefund_bank(rset.getString("REFUND_BANK"));
				r.setRefund_account(rset.getString("REFUND_ACCOUNT"));
				r.setRefund_money(rset.getInt("REFUND_MONEY"));
				r.setRefund_StatusYN(rset.getInt("REFUNDLIST_YN"));
				
				
				cashlist.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return cashlist;
	}

	//리뷰 정보 불러오기
	public ArrayList<HashMap<String, Object>> reviewSeller(Connection con, int dealnum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String, Object>> reviewlist= null;
		
		String query = prop.getProperty("reviewSeller");
		
		try {
			pstmt=con.prepareStatement(query);
			
			
			pstmt.setInt(1, dealnum);
			
			rset= pstmt.executeQuery();
			
			
			reviewlist = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				HashMap<String, Object> p = new HashMap<>();
				
				p.put("thumnailImg", 	rset.getString("CHANGENAME"));
				p.put("productName",	rset.getString("PRODUCT_NAME"));
				p.put("productContent",	rset.getString("PRODUCT_CONTEXT"));
				
				
				reviewlist.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		return reviewlist;
	}


	//구매평 작성 데이터 삽입
	public int ReviewUpdate(Connection con, int loginCode, int rstar, String rtext, int productNo) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("ReviewUpdate");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, loginCode);
			pstmt.setString(3, rtext);
			pstmt.setInt(4, rstar);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
	
		return result;
	}

	//구매평 상태 변경
	public int reviewStateUpdate(Connection con, int dealnum) {
		PreparedStatement pstmt = null;
		int result =0;
		
		String query = prop.getProperty("reviewStateUpdate");
		
		
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


	
}
