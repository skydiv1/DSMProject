package com.kh.w7.deal.model.vo;

public class DealList implements java.io.Serializable{
	private int dealNo;					// 거래번호
	private String addmessage1;	// 추가 메세지1
	private String addmessage2; 	// 추가 메세지2
	private int dealListCategory;	// 분류
	
	public DealList() {
		super();
	}

	public DealList(int dealNo, String addmessage1, String addmessage2, int dealListCategory) {
		super();
		this.dealNo = dealNo;
		this.addmessage1 = addmessage1;
		this.addmessage2 = addmessage2;
		this.dealListCategory = dealListCategory;
	}

	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	public String getAddmessage1() {
		return addmessage1;
	}

	public void setAddmessage1(String addmessage1) {
		this.addmessage1 = addmessage1;
	}

	public String getAddmessage2() {
		return addmessage2;
	}

	public void setAddmessage2(String addmessage2) {
		this.addmessage2 = addmessage2;
	}

	public int getDealListCategory() {
		return dealListCategory;
	}

	public void setDealListCategory(int dealListCategory) {
		this.dealListCategory = dealListCategory;
	}

	@Override
	public String toString() {
		return "DealList [dealNo=" + dealNo + ", addmessage1=" + addmessage1 + ", addmessage2=" + addmessage2
				+ ", dealListCategory=" + dealListCategory + "]";
	}
	
	
}
