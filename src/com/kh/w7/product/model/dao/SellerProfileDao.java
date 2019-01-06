package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.w7.common.Attachment;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.vo.Product;

public class SellerProfileDao {
	private Properties prop = new Properties();

	public SellerProfileDao() {
		String fileName = ProductDao.class.getResource("/sql/product/sellerProfile-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Object> selectSellerList(Connection con, int memberCode, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		ArrayList<Product> pList = null;
		ArrayList<Attachment> imgList = null;

		Product product = null;
		Member member = null;		
		Attachment attachment = null;
		
		String query = prop.getProperty("selectList");
		//System.out.println("query: "+query);
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1; // 조회할 때 시작할 행 번호
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, memberCode);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rset = pstmt.executeQuery();

			pList = new ArrayList<Product>();
			imgList = new ArrayList<Attachment>();

			int cnt=0;
			while (rset.next()) {
				/* product */	
				product = new Product();				
				product.setProductNo(rset.getInt("PRODUCT_NO"));
				product.setMemberCode(rset.getInt("MEMBER_CODE"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductCategory(rset.getString("PRODUCT_CATEGORY"));
				product.setProductItem(rset.getString("PRODUCT_ITEM"));
				product.setProductItemPrice(rset.getInt("PRODUCT_ITEMPRICE"));
				product.setProductContext(rset.getString("PRODUCT_CONTEXT"));
				product.setRegisterDate(rset.getDate("PRODUCT_REGISTERDATE"));
				product.setDeleteYN(rset.getInt("PRODUCT_DELETEYN"));

				pList.add(product);

				/* img */ // I.IMG_NO, I.CHANGENAME, I.IMG_LEVEL
				attachment = new Attachment();
				attachment.setImgNo(rset.getInt("IMG_NO"));
				attachment.setChangeName(rset.getString("CHANGENAME"));
				attachment.setImgLevel(rset.getInt("IMG_LEVEL"));
				
				imgList.add(attachment);
				
				/* member */				
				member = new Member();
				member.setMemberCode(rset.getInt("MEMBER_CODE"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setSellerIntroduction(rset.getString("SELLER_INTRODUCTION"));
				member.setSellerGrade(rset.getInt("SELLER_GRADE"));
				member.setSellerCareer(rset.getString("SELLER_CAREER"));

				cnt++;
			}

			hmap = new HashMap<String, Object>();
			
			hmap.put("product", pList);
			hmap.put("attachment", imgList);
			hmap.put("member", member);
			//System.out.println("selectSellerList(selectList) :  "+pList);
			System.out.println("member(selectSellerList) DAO"+member);
			System.out.println("selectSellerList 몇 번 도는지 확인 : "+cnt);
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return hmap;
	}

	
	/* 트겅 판매자의 게시물 수 */
	public int getListCount(Connection con, int memberCode) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			pstmt = con.prepareStatement(query);		
			pstmt.setInt(1, memberCode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("listCount(특정 판매자 게시물 총 개수) : "+listCount);
		return listCount;
	}

	
	/* 베스트 판매자 */
	public Member findBestSeller(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member bestSeller = null;

		String query = prop.getProperty("bestSellerSelect");

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {

				bestSeller = new Member();
				bestSeller.setMemberCode(rset.getInt("MEMBER_CODE"));
				bestSeller.setMemberId(rset.getString("MEMBER_ID"));
				bestSeller.setMemberPwd(rset.getString("MEMBER_PWD"));
				bestSeller.setMemberName(rset.getString("MEMBER_NAME"));
				bestSeller.setMemberPhone(rset.getString("MEMBER_PHONE"));
				bestSeller.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				bestSeller.setMemberCategory(rset.getInt("MEMBER_CATEGORY"));
				bestSeller.setSellerIntroduction(rset.getString("SELLER_INTRODUCTION"));
				bestSeller.setSellerGrade(rset.getInt("SELLER_GRADE"));
				bestSeller.setMemberAdmin(rset.getInt("MEMBER_ADMIN"));
				bestSeller.setMemberStatus(rset.getInt("MEMBER_STATUS"));
				bestSeller.setSellerAccountName(rset.getString("SELLER_ACCOUNTNAME"));
				bestSeller.setSellerBank(rset.getString("SELLER_BANK"));
				bestSeller.setSellerAccount(rset.getString("SELLER_ACCOUNT"));
				bestSeller.setSellerCareer(rset.getString("SELLER_CAREER"));
				bestSeller.setSellerCertcheck(rset.getInt("SELLER_CERTCHECK"));			

			}
			System.out.println("bestSeller(확인): " + bestSeller);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return bestSeller;
	}

	
	/* 특정 판매자의 리뷰 개수 */
	public int selectReviewCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		System.out.println("listCount(특정 판매자의 리뷰 개수DAO) : "+listCount);
		return listCount;
	}

}
