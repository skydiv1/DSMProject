package com.kh.w7.product.model.vo;

import java.sql.Date;

public class Product implements java.io.Serializable{
	private int productNo;				// 상품번호
	private int memberCode;			// 판매자코드
	private String productName;		// 상품제목
	private String productCategory;	// 상품카테고리
	private String productItem;		// 상품기본항목
	private int productItemPrice;	// 상품기본항목가격
	private String productContext;	// 상품설명
	private Date registerDate;		// 상품 등록일자
	private int deleteYN;				// 삭제여부
	
	private String plusProductItem;	// 상품 추가 항목
	private int plusProductPrice;		// 추가 항목 가격
	
	public Product() {}
	
	public Product(int productNo, int memberCode, String productName, String productCategory, String productItem,
			int productItemPrice, String productContext, Date registerDate, int deleteYN, String plusProductItem,
			int plusProductPrice) {
		super();
		this.productNo = productNo;
		this.memberCode = memberCode;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productItem = productItem;
		this.productItemPrice = productItemPrice;
		this.productContext = productContext;
		this.registerDate = registerDate;
		this.deleteYN = deleteYN;
		this.plusProductItem = plusProductItem;
		this.plusProductPrice = plusProductPrice;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public int getProductItemPrice() {
		return productItemPrice;
	}

	public void setProductItemPrice(int productItemPrice) {
		this.productItemPrice = productItemPrice;
	}

	public String getProductContext() {
		return productContext;
	}

	public void setProductContext(String productContext) {
		this.productContext = productContext;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public int getDeleteYN() {
		return deleteYN;
	}

	public void setDeleteYN(int deleteYN) {
		this.deleteYN = deleteYN;
	}

	public String getPlusProductItem() {
		return plusProductItem;
	}

	public void setPlusProductItem(String plusProductItem) {
		this.plusProductItem = plusProductItem;
	}

	public int getPlusProductPrice() {
		return plusProductPrice;
	}

	public void setPlusProductPrice(int plusProductPrice) {
		this.plusProductPrice = plusProductPrice;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", memberCode=" + memberCode + ", productName=" + productName
				+ ", productCategory=" + productCategory + ", productItem=" + productItem + ", productItemPrice="
				+ productItemPrice + ", productContext=" + productContext + ", registerDate=" + registerDate
				+ ", deleteYN=" + deleteYN + ", plusProductItem=" + plusProductItem + ", plusProductPrice="
				+ plusProductPrice + "]";
	}
}
