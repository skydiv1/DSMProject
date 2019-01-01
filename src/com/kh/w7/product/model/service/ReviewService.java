package com.kh.w7.product.model.service;

import static com.kh.w7.common.JDBCTemplate.close;
import static com.kh.w7.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.product.model.dao.ReviewDao;
import com.kh.w7.product.model.vo.Review;

public class ReviewService {

	/* 리뷰 목록 페이지 조회 */
	public ArrayList<Review> selectReviewList() {
		Connection con = getConnection();
		
		ArrayList<Review> reviewList = new ReviewDao().selectReviewList(con);
		
		close(con);	
		
		return reviewList;
	}

}
