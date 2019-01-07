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


	/* 베스트 판매자 */
	public ArrayList<HashMap<String, Object>> selectBestSeller() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new SellerProfileDao().selectBestSeller(con);
		
		close(con);
		
		System.out.println("list(service)확인: "+list);
		
		return list;
	}


	/* 해당 판매자 전체 게시글 수 조회 */
	public int getListCount(int memberCode) {
		Connection con = getConnection();
		int listCount = new SellerProfileDao().getListCount(con, memberCode);
		close(con);	

		return listCount;
	}


}
