package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
	public ArrayList<Review> selectReviewList(Connection con, String productNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviewList = null;

		String query = prop.getProperty("selectList");
		//String query = "SELECT R.REVIEW_NO, R.PRODUCT_NO, R.MEMBER_CODE, M.MEMBER_ID, R.REVIEW_CONTEXT, R.REVIEW_DATE, R.REVIEW_GRADE, R.REVIEW_DELETEYN FROM REVIEW R INNER JOIN MEMBER M ON (R.MEMBER_CODE=M.MEMBER_CODE) WHERE PRODUCT_NO=?";
		// TO_CHAR(R.REVIEW_DATE, 'YYYYMMDD HH24:MI:SS') AS REVIEW_DATE : IllegalArgumentException 오류발생
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(productNum));

			rset = pstmt.executeQuery();
			
			reviewList = new ArrayList<Review>();

			int i=0;
			while (rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setProductNo(rset.getInt("PRODUCT_NO"));
				review.setMemberCode(rset.getInt("MEMBER_CODE"));
				review.setReviewContext(rset.getString("REVIEW_CONTEXT"));
				review.setReviewDate(rset.getDate("REVIEW_DATE"));
				review.setReviewGrade(rset.getInt("REVIEW_GRADE"));
				review.setReviewDeleteYN(rset.getInt("REVIEW_DELETEYN"));
				review.setMemberId(rset.getString("MEMBER_ID"));

				reviewList.add(review);
				i++;
				System.out.println(i);
			}
			System.out.println("i는? "+i);
			System.out.println("ReviewDao(selectList) :  "+reviewList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return reviewList;
	}

	public ArrayList<Review> selectAllReviewList(Connection con, int memberCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviewAllList = null;

		String query = prop.getProperty("selectAllList");
	
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberCode);

			rset = pstmt.executeQuery();
			
			reviewAllList = new ArrayList<Review>();

			int i=0;
			while (rset.next()) {
				Review review = new Review();
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setProductNo(rset.getInt("PRODUCT_NO"));
				review.setMemberCode(rset.getInt("MEMBER_CODE"));
				review.setMemberId(rset.getString("MEMBER_ID"));
				review.setReviewContext(rset.getString("REVIEW_CONTEXT"));
				review.setReviewDate(rset.getDate("REVIEW_DATE"));
				review.setReviewGrade(rset.getInt("REVIEW_GRADE"));

				reviewAllList.add(review);
			}
			System.out.println("ReviewDao(selectAllList) :  "+reviewAllList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return reviewAllList;
	}

}
