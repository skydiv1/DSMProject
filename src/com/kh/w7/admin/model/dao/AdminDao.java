package com.kh.w7.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.w7.common.JDBCTemplate.*;

import com.kh.w7.admin.model.vo.Admin;
import com.kh.w7.admin.model.vo.Cash;
import com.kh.w7.admin.model.vo.ProductExcel;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.pay.model.dao.PayDao;
import com.kh.w7.refund.model.vo.Refund;

public class AdminDao {
	
	private Properties prop = new Properties();
	
	public AdminDao() {
		
		String fileName= AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Refund> SelectAllRefundMember(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Refund r = null;
		ArrayList<Refund> list = new ArrayList<Refund>();
		
		String query = prop.getProperty("SelectAllRefundMember");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Refund();
				r.setRefund_no(rset.getInt(1));
				r.setMember_name(rset.getString(2));
				r.setRefund_bank(rset.getString(3));
				r.setRefund_account(rset.getString(4));
				r.setMember_birth(rset.getString(5));
				r.setRefund_money(rset.getInt(6));
				r.setRefund_applyDate(rset.getDate(7));
				r.setRefund_StatusYN(rset.getInt(8));
				
				list.add(r);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
			
		}

		return list;
	}

	public int updateRefundStatus(Connection con, int refundNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateRefundStatus");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, refundNo);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public ArrayList<Member> selectAllMember(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = prop.getProperty("selectAllMember");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Member();
				
				m.setMemberCode(rset.getInt(1));
				m.setMemberId(rset.getString(2));
				m.setMemberName(rset.getString(3));
				m.setMemberEmail(rset.getString(4));
				m.setMemberPhone(rset.getString(5));
				m.setMemberCategory(rset.getInt(6));
				m.setMemberStatus(rset.getInt(7));
				m.setBlackCount(rset.getInt(8));
				m.setSellerCertcheck(rset.getInt(9));
				m.setSellerImgPath(rset.getString(10));
				
				
				list.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return list;
	}

	public int memberDelete(Connection con, int memberCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("memberDelete");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}

	public int countPlusMinus(Connection con, String what, int memberCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		
		
		if(what.equals("plus")) {
			query = prop.getProperty("countPlus");
		}else{
			query = prop.getProperty("countMinus");
		}
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			result = pstmt.executeUpdate(); //여기가 실행이 안됨
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		System.out.println("DaoResult : " + result);
		
		return result;
	}

	public int memberLightOutF(Connection con, int memberCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("memberLightOutF");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int memberHeavyOutF(Connection con, int memberCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("memberHeavyOutF");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int memberRestoreF(Connection con, int memberCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("memberRestoreF");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int imgCert(Connection con, int memberCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("imgCert");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public ArrayList<Board> selectAllBoard(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		String query = prop.getProperty("selectAllBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				b = new Board();
				
				b.setBoardNo(rset.getInt(1));
				b.setBoardTitle(rset.getString(2));
				b.setMemberName(rset.getString(3));
				b.setBoardDate(rset.getDate(4));
				b.setBoardQnaAnswerYn(rset.getInt(5));
				
				
				list.add(b);
			}
			
			
			System.out.println(list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}

	public Admin refreshPage(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Admin ad = null;
		
		
		String query = prop.getProperty("refreshPage");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ad = new Admin();
				
				ad.setCustomerCount(rset.getInt(1));
				ad.setSellerCount(rset.getInt(2));
				ad.setMoneyPlus(rset.getInt(3));
				ad.setMoneyMinus(rset.getInt(4));
				ad.setMoneyDeal(rset.getInt(5));
				ad.setTax(rset.getInt(6));
				ad.setDealCount(rset.getInt(7));
				ad.setProductCount(rset.getInt(8));
				ad.setBoardCount(rset.getInt(9));
				ad.setMemberCount(rset.getInt(10));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return ad;
	}

	public int procedureHomePage(Connection con) {
		// TODO Auto-generated method stub
		CallableStatement cstmt = null;
		
		int result = 0;
		
		String procedureQuery = prop.getProperty("procedureHomePage");
		
		try {
			cstmt = con.prepareCall("{call homepage_procedure}");
			cstmt.execute();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(cstmt);
		}
		
		
		
		return result;
	}

	public ArrayList<Cash> cashConvertExcel(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Cash c = null;
		ArrayList<Cash> list = new ArrayList<Cash>();
		
		String query = prop.getProperty("cashConvertExcel");
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				c = new Cash();
				c.setMemberCashCode(rset.getInt(1));
				c.setMemberCode(rset.getInt(2));
				c.setMemberId(rset.getString(3));
				c.setMemberCashNowCash(rset.getInt(4));
				c.setMemberCashCategory(rset.getInt(5));
				c.setDealNo(rset.getInt(6));
				c.setDealMoney(rset.getInt(7));
				c.setPayNo(rset.getInt(8));
				c.setPayMoney(rset.getInt(9));
				c.setRefundNo(rset.getInt(10));
				c.setRefundMoney(rset.getInt(11));
				
				
				
				list.add(c);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	public ArrayList<ProductExcel> ProductConvertExcel(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProductExcel pe = null;
		ArrayList<ProductExcel> list = new ArrayList<ProductExcel>();
		
		String query = prop.getProperty("ProductConvertExcel");
		
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pe = new ProductExcel();
				
				pe.setProductNo(rset.getInt(1));
				pe.setMemberCode(rset.getInt(2));
				pe.setMemberId(rset.getString(3));
				pe.setMemberName(rset.getString(4));
				pe.setProductName(rset.getString(5));
				//pe.setProductCategory(rset.getInt(6)); //여기부분 문제
				pe.setProductContext(rset.getString(6));
				pe.setProductItem(rset.getString(7));
				pe.setProductPrice(rset.getInt(8));
				pe.setPlusproductItem(rset.getString(9));
				pe.setPlusproductPrice(rset.getInt(10));
				pe.setProductRegisterDate(rset.getDate(11));
				pe.setProductDeleteYN(rset.getInt(12));
				
				
				list.add(pe);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return list;
	}

	public ArrayList<Member> MemberConvertExcel(Connection con) {
		// TODO Auto-generated method stub
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Member m = null;
			ArrayList<Member> list = new ArrayList<Member>();
			
			String query = prop.getProperty("MemberConvertExcel");
			
			try {
				pstmt = con.prepareStatement(query);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					m = new Member();
					
					m.setMemberCode(rset.getInt(1));
					m.setMemberId(rset.getString(2));
					m.setMemberName(rset.getString(3));
					m.setMemberEmail(rset.getString(4));
					m.setMemberPhone(rset.getString(5));
					m.setMemberCategory(rset.getInt(6));
					m.setSellerIntroduction(rset.getString(7));
					m.setSellerGrade(rset.getInt(8));
					m.setMemberStatus(rset.getInt(9));
					m.setSellerBank(rset.getString(10));
					m.setSellerAccount(rset.getString(11));
					m.setSellerCareer(rset.getString(12));
					m.setSellerCertcheck(rset.getInt(13));
					m.setSellerImgPath(rset.getString(14));
					m.setBlackCount(rset.getInt(15));
					

					list.add(m);
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);
			}
			
			
			return list;
	}

	public ArrayList<Board> BoardConvertExcel(Connection con) {
		// TODO Auto-generated method stub
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			Board b = null;
			ArrayList<Board> list = new ArrayList<Board>();
			
			String query = prop.getProperty("BoardConvertExcel");
			
			try {
				pstmt = con.prepareStatement(query);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					b = new Board();
					b.setBoardNo(rset.getInt(1));
					b.setMemberCode(rset.getInt(2));
					b.setMemberName(rset.getString(3));
					b.setBoardTitle(rset.getString(4));
					b.setBoardContext(rset.getString(5));
					b.setBoardDate(rset.getDate(6));
					b.setBoardCategory(rset.getInt(7));
					b.setBoardCount(rset.getInt(8));
					b.setBoardDelete(rset.getInt(9));
					b.setBoardQnaAnswerYn(rset.getInt(10));
					
					
					
					
					list.add(b);
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rset);
			}
			
			
			return list;
	}

}
