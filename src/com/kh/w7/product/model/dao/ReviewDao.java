package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.w7.product.model.vo.Product;
import com.kh.w7.product.model.vo.Review;

public class ReviewDao {
	private Properties prop = new Properties();

	public ReviewDao() {
		String fileName = ProductDao.class.getResource("/sql/product/review-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 리뷰 목록 페이지 조회 */
	public ArrayList<Review> selectReviewList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviewList = null;

		String query = prop.getProperty("selectList");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			reviewList = new ArrayList<Review>();

			while (rset.next()) {
				Review review = new Review();
				
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setProductNo(rset.getInt("PRODUCT_NO"));
				review.setMemberCode(rset.getInt("MEMBER_CODE"));
				review.setReviewContext(rset.getString("REVIEW_CONTEXT"));
				review.setReviewDate(rset.getDate("REVIEW_DATE"));
				review.setReviewGrade(rset.getInt("REVIEW_GRADE"));
				review.setReviewDeleteYN(rset.getInt("REVIEW_DELETEYN"));
				review.setMemberId(rset.getInt("MEMBER_ID"));

				reviewList.add(review);
			}
			System.out.println("ReviewDao(selectList) :  "+reviewList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		return reviewList;
	}

}
