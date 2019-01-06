package com.kh.w7.product.model.service;

import static com.kh.w7.common.JDBCTemplate.close;
import static com.kh.w7.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.w7.member.model.dao.MemberDao;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.dao.ProductDao;
import com.kh.w7.product.model.dao.ReviewDao;
import com.kh.w7.product.model.dao.SellerProfileDao;
import com.kh.w7.product.model.vo.Product;
import com.kh.w7.product.model.vo.Review;

public class SellerProfileService {

	public HashMap<String, Object> selectSellerList(int memberCode, int currentPage, int limit) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = new SellerProfileDao().selectSellerList(con, memberCode, currentPage, limit);
		
		close(con);
		
		return hmap;
	}

	
	/* 해당 판매자 전체 게시글 수 조회 */
	public int getListCount(int memberCode) {
		Connection con = getConnection();
		int listCount = new SellerProfileDao().getListCount(con, memberCode);
		close(con);	

		return listCount;
	}


	/* 베스트 판매자 */
	public Member findBestSeller() {
		Connection con = getConnection();
		Member bestSeller = new SellerProfileDao().findBestSeller(con);
		close(con);
		return bestSeller;
	}


	/* 특정 판매자의 리뷰 개수 */
	public int selectReviewList() {
		Connection con = getConnection();		
		int reviewCount = new SellerProfileDao().selectReviewCount(con);		
		close(con);	
		return reviewCount;
	}

}
