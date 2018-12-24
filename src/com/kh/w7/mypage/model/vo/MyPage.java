package com.kh.w7.mypage.model.vo;

import java.sql.Date;

public class MyPage {
	
	private int dealNo;//거래번호
	private int productNo;//상품번호
	private String productName;//상품명
	private String productContext;//삼품내용
	private int customerCode;//소비자 코드
	private int sellerCode;//판매자코드
	private String dealListaddMsg;//추가메세지
	private int dealListCategory;//진행 상태분류
	private int dealPrice;//거래금액
	private int reviewNo;//리뷰번호
	private String reviewContxt;//리뷰내용
	private Date reviewDate;//작성시간
	private int reviewGrade;//작성시간
	
	
	public MyPage() {
		// TODO Auto-generated constructor stub
	}


	public MyPage(int dealNo, int productNo, String productName, String productContext, int customerCode,
			int sellerCode, String dealListaddMsg, int dealListCategory, int dealPrice, int reviewNo,
			String reviewContxt, Date reviewDate, int reviewGrade) {
		super();
		this.dealNo = dealNo;
		this.productNo = productNo;
		this.productName = productName;
		this.productContext = productContext;
		this.customerCode = customerCode;
		this.sellerCode = sellerCode;
		this.dealListaddMsg = dealListaddMsg;
		this.dealListCategory = dealListCategory;
		this.dealPrice = dealPrice;
		this.reviewNo = reviewNo;
		this.reviewContxt = reviewContxt;
		this.reviewDate = reviewDate;
		this.reviewGrade = reviewGrade;
	}


	@Override
	public String toString() {
		return "MyPage [dealNo=" + dealNo + ", productNo=" + productNo + ", productName=" + productName
				+ ", productContext=" + productContext + ", customerCode=" + customerCode + ", sellerCode=" + sellerCode
				+ ", dealListaddMsg=" + dealListaddMsg + ", dealListCategory=" + dealListCategory + ", dealPrice="
				+ dealPrice + ", reviewNo=" + reviewNo + ", reviewContxt=" + reviewContxt + ", reviewDate=" + reviewDate
				+ ", reviewGrade=" + reviewGrade + "]";
	}


	public int getDealNo() {
		return dealNo;
	}


	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductContext() {
		return productContext;
	}


	public void setProductContext(String productContext) {
		this.productContext = productContext;
	}


	public int getCustomerCode() {
		return customerCode;
	}


	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}


	public int getSellerCode() {
		return sellerCode;
	}


	public void setSellerCode(int sellerCode) {
		this.sellerCode = sellerCode;
	}


	public String getDealListaddMsg() {
		return dealListaddMsg;
	}


	public void setDealListaddMsg(String dealListaddMsg) {
		this.dealListaddMsg = dealListaddMsg;
	}


	public int getDealListCategory() {
		return dealListCategory;
	}


	public void setDealListCategory(int dealListCategory) {
		this.dealListCategory = dealListCategory;
	}


	public int getDealPrice() {
		return dealPrice;
	}


	public void setDealPrice(int dealPrice) {
		this.dealPrice = dealPrice;
	}


	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public String getReviewContxt() {
		return reviewContxt;
	}


	public void setReviewContxt(String reviewContxt) {
		this.reviewContxt = reviewContxt;
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
	
	
	
	
}





