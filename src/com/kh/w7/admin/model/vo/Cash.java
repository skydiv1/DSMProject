package com.kh.w7.admin.model.vo;

public class Cash implements java.io.Serializable{
	private int memberCashCode;
	private int memberCode;
	private int memberCashNowCash;
	private int memberCashCategory;
	private int dealNo;
	private int dealMoney;
	private int payNo;
	private int payMoney;
	private int refundNo;
	private int refundMoney;
	private String memberName;
	private String memberId;
	
	public Cash() {
		
	}

	public Cash(int memberCashCode, int memberCode, int memberCashNowCash, int memberCashCategory, int dealNo,
			int dealMoney, int payNo, int payMoney, int refundNo, int refundMoney, String memberName, String memberId) {
		super();
		this.memberCashCode = memberCashCode;
		this.memberCode = memberCode;
		this.memberCashNowCash = memberCashNowCash;
		this.memberCashCategory = memberCashCategory;
		this.dealNo = dealNo;
		this.dealMoney = dealMoney;
		this.payNo = payNo;
		this.payMoney = payMoney;
		this.refundNo = refundNo;
		this.refundMoney = refundMoney;
		this.memberName = memberName;
		this.memberId = memberId;
	}

	public int getMemberCashCode() {
		return memberCashCode;
	}

	public void setMemberCashCode(int memberCashCode) {
		this.memberCashCode = memberCashCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public int getMemberCashNowCash() {
		return memberCashNowCash;
	}

	public void setMemberCashNowCash(int memberCashNowCash) {
		this.memberCashNowCash = memberCashNowCash;
	}

	public int getMemberCashCategory() {
		return memberCashCategory;
	}

	public void setMemberCashCategory(int memberCashCategory) {
		this.memberCashCategory = memberCashCategory;
	}

	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	public int getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(int dealMoney) {
		this.dealMoney = dealMoney;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public int getRefundNo() {
		return refundNo;
	}

	public void setRefundNo(int refundNo) {
		this.refundNo = refundNo;
	}

	public int getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(int refundMoney) {
		this.refundMoney = refundMoney;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Cash [memberCashCode=" + memberCashCode + ", memberCode=" + memberCode + ", memberCashNowCash="
				+ memberCashNowCash + ", memberCashCategory=" + memberCashCategory + ", dealNo=" + dealNo
				+ ", dealMoney=" + dealMoney + ", payNo=" + payNo + ", payMoney=" + payMoney + ", refundNo=" + refundNo
				+ ", refundMoney=" + refundMoney + ", memberName=" + memberName + ", memberId=" + memberId + "]";
	}

	
	
}
