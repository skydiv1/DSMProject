package com.kh.w7.admin.model.vo;

public class Admin implements java.io.Serializable{
	private int customerCount; //전체 소비자수
	private int sellerCount; //전체 판매자수
	private int moneyPlus; //총 충전금액
	private int moneyMinus; //총 환급금액
	private int moneyDeal; //총 거래금액
	private int tax; //취득 수수료
	private int dealCount; //총 거래건수
	private int productCount; //총 상품글 수
	private int boardCount; //총 게시글 수
	private int memberCount; //소비자, 판매자, 관리자 전체 회원수
	
	public Admin() {
		
	}

	public Admin(int customerCount, int sellerCount, int moneyPlus, int moneyMinus, int moneyDeal, int tax,
			int dealCount, int productCount, int boardCount, int memberCount) {
		super();
		this.customerCount = customerCount;
		this.sellerCount = sellerCount;
		this.moneyPlus = moneyPlus;
		this.moneyMinus = moneyMinus;
		this.moneyDeal = moneyDeal;
		this.tax = tax;
		this.dealCount = dealCount;
		this.productCount = productCount;
		this.boardCount = boardCount;
		this.memberCount = memberCount;
	}

	public int getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	public int getSellerCount() {
		return sellerCount;
	}

	public void setSellerCount(int sellerCount) {
		this.sellerCount = sellerCount;
	}

	public int getMoneyPlus() {
		return moneyPlus;
	}

	public void setMoneyPlus(int moneyPlus) {
		this.moneyPlus = moneyPlus;
	}

	public int getMoneyMinus() {
		return moneyMinus;
	}

	public void setMoneyMinus(int moneyMinus) {
		this.moneyMinus = moneyMinus;
	}

	public int getMoneyDeal() {
		return moneyDeal;
	}

	public void setMoneyDeal(int moneyDeal) {
		this.moneyDeal = moneyDeal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getDealCount() {
		return dealCount;
	}

	public void setDealCount(int dealCount) {
		this.dealCount = dealCount;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	@Override
	public String toString() {
		return "Admin [customerCount=" + customerCount + ", sellerCount=" + sellerCount + ", moneyPlus=" + moneyPlus
				+ ", moneyMinus=" + moneyMinus + ", moneyDeal=" + moneyDeal + ", tax=" + tax + ", dealCount="
				+ dealCount + ", productCount=" + productCount + ", boardCount=" + boardCount + ", memberCount="
				+ memberCount + "]";
	}
	
	
	
	
	
}
