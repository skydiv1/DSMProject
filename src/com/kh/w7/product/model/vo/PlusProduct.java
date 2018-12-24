package com.kh.w7.product.model.vo;

public class PlusProduct implements java.io.Serializable{
	//private int plusProductNo;			// 추가되는 항목의 고유번호 (기본키)
	private int productNo;					// 상품번호 (복합키 사용)
	private String plusProductItem;		// 상품 추가 항목 (복합키 사용)
	private int plusProductPrice;			// 추가항목 가격
	
	public PlusProduct() {}

	public PlusProduct(int productNo, String plusProductItem, int plusProductPrice) {
		super();
		this.productNo = productNo;
		this.plusProductItem = plusProductItem;
		this.plusProductPrice = plusProductPrice;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
		return "PlusProduct [productNo=" + productNo + ", plusProductItem=" + plusProductItem + ", plusProductPrice="
				+ plusProductPrice + "]";
	}
}
