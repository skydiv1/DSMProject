package com.kh.w7.admin.model.vo;

import java.sql.Date;

public class ProductExcel implements java.io.Serializable{
	private int productNo;
	private int memberCode;
	private String memberId;
	private String memberName;
	private String productName;
	private int productCategory;
	private String productItem;
	private int productPrice;
	private String productContext;
	private Date productRegisterDate;
	private int productDeleteYN;
	private String plusproductItem;
	private int plusproductPrice;
	
	public ProductExcel() {
		
	}

	public ProductExcel(int productNo, int memberCode, String memberId, String memberName, String productName,
			int productCategory, String productItem, int productPrice, String productContext, Date productRegisterDate,
			int productDeleteYN, String plusproductItem, int plusproductPrice) {
		super();
		this.productNo = productNo;
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.memberName = memberName;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productItem = productItem;
		this.productPrice = productPrice;
		this.productContext = productContext;
		this.productRegisterDate = productRegisterDate;
		this.productDeleteYN = productDeleteYN;
		this.plusproductItem = plusproductItem;
		this.plusproductPrice = plusproductPrice;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductItem() {
		return productItem;
	}

	public void setProductItem(String productItem) {
		this.productItem = productItem;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductContext() {
		return productContext;
	}

	public void setProductContext(String productContext) {
		this.productContext = productContext;
	}

	public Date getProductRegisterDate() {
		return productRegisterDate;
	}

	public void setProductRegisterDate(Date productRegisterDate) {
		this.productRegisterDate = productRegisterDate;
	}

	public int getProductDeleteYN() {
		return productDeleteYN;
	}

	public void setProductDeleteYN(int productDeleteYN) {
		this.productDeleteYN = productDeleteYN;
	}

	public String getPlusproductItem() {
		return plusproductItem;
	}

	public void setPlusproductItem(String plusproductItem) {
		this.plusproductItem = plusproductItem;
	}

	public int getPlusproductPrice() {
		return plusproductPrice;
	}

	public void setPlusproductPrice(int plusproductPrice) {
		this.plusproductPrice = plusproductPrice;
	}

	@Override
	public String toString() {
		return "ProductExcel [productNo=" + productNo + ", memberCode=" + memberCode + ", memberId=" + memberId
				+ ", memberName=" + memberName + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", productItem=" + productItem + ", productPrice=" + productPrice + ", productContext="
				+ productContext + ", productRegisterDate=" + productRegisterDate + ", productDeleteYN="
				+ productDeleteYN + ", plusproductItem=" + plusproductItem + ", plusproductPrice=" + plusproductPrice
				+ "]";
	}
	
	
	
}
