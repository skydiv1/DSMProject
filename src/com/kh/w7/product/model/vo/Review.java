package com.kh.w7.product.model.vo;

import java.sql.Date;

public class Review implements java.io.Serializable{
	private int reviewNo;				// 리뷰번호 / 시퀀스(SEQ_REVIEW)
	private int productNo;				// 상품번호
	private int memberCode;			// 회원코드
	private int memberId;				// 회원아이디 (member 테이블에서 조인으로 가져온다.)
	private String reviewContext;	// 리뷰내용
	private Date reviewDate;			// 작성시간
	private int reviewGrade;			// 별점
	private int reviewDeleteYN;		// 삭제여부
	
	public Review() {}

	public Review(int reviewNo, int productNo, int memberCode, int memberId, String reviewContext, Date reviewDate,
			int reviewGrade, int reviewDeleteYN) {
		super();
		this.reviewNo = reviewNo;
		this.productNo = productNo;
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.reviewContext = reviewContext;
		this.reviewDate = reviewDate;
		this.reviewGrade = reviewGrade;
		this.reviewDeleteYN = reviewDeleteYN;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getReviewContext() {
		return reviewContext;
	}

	public void setReviewContext(String reviewContext) {
		this.reviewContext = reviewContext;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewGrade() {
		return reviewGrade;
	}

	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}

	public int getReviewDeleteYN() {
		return reviewDeleteYN;
	}

	public void setReviewDeleteYN(int reviewDeleteYN) {
		this.reviewDeleteYN = reviewDeleteYN;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", productNo=" + productNo + ", memberCode=" + memberCode
				+ ", memberId=" + memberId + ", reviewContext=" + reviewContext + ", reviewDate=" + reviewDate
				+ ", reviewGrade=" + reviewGrade + ", reviewDeleteYN=" + reviewDeleteYN + "]";
	}
}
