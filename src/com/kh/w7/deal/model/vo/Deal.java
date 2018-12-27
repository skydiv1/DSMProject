package com.kh.w7.deal.model.vo;

public class Deal implements java.io.Serializable{

	private int dealNo;
	private int productNo;
	private String imgFilePath;
	private String productTitle;
	private String productContext;
	private int customerCode;
	private int sellerCode;
	private String mainProductName;
	private int mainProductPrice;
	private String subProductName;
	private int subProductPrice;
	private int memberNowCash;
	
	public Deal() {
		
	}

	public Deal(int dealNo, int productNo, String imgFilePath, String productTitle, String productContext,
			int customerCode, int sellerCode, String mainProductName, int mainProductPrice, String subProductName,
			int subProductPrice, int memberNowCash) {
		super();
		this.dealNo = dealNo;
		this.productNo = productNo;
		this.imgFilePath = imgFilePath;
		this.productTitle = productTitle;
		this.productContext = productContext;
		this.customerCode = customerCode;
		this.sellerCode = sellerCode;
		this.mainProductName = mainProductName;
		this.mainProductPrice = mainProductPrice;
		this.subProductName = subProductName;
		this.subProductPrice = subProductPrice;
		this.memberNowCash = memberNowCash;
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

	public String getImgFilePath() {
		return imgFilePath;
	}

	public void setImgFilePath(String imgFilePath) {
		this.imgFilePath = imgFilePath;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
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

	public String getMainProductName() {
		return mainProductName;
	}

	public void setMainProductName(String mainProductName) {
		this.mainProductName = mainProductName;
	}

	public int getMainProductPrice() {
		return mainProductPrice;
	}

	public void setMainProductPrice(int mainProductPrice) {
		this.mainProductPrice = mainProductPrice;
	}

	public String getSubProductName() {
		return subProductName;
	}

	public void setSubProductName(String subProductName) {
		this.subProductName = subProductName;
	}

	public int getSubProductPrice() {
		return subProductPrice;
	}

	public void setSubProductPrice(int subProductPrice) {
		this.subProductPrice = subProductPrice;
	}

	public int getMemberNowCash() {
		return memberNowCash;
	}

	public void setMemberNowCash(int memberNowCash) {
		this.memberNowCash = memberNowCash;
	}

	@Override
	public String toString() {
		return "Deal [dealNo=" + dealNo + ", productNo=" + productNo + ", imgFilePath=" + imgFilePath
				+ ", productTitle=" + productTitle + ", productContext=" + productContext + ", customerCode="
				+ customerCode + ", sellerCode=" + sellerCode + ", mainProductName=" + mainProductName
				+ ", mainProductPrice=" + mainProductPrice + ", subProductName=" + subProductName + ", subProductPrice="
				+ subProductPrice + ", memberNowCash=" + memberNowCash + "]";
	}

	
	
}
