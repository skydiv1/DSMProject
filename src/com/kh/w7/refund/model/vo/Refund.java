package com.kh.w7.refund.model.vo;

import java.sql.Date;

public class Refund implements java.io.Serializable{

	private int refund_no; //신청 번호
	private int member_code; //신청 회원
	private int refund_money; //환급금액
	private String member_name;
	private String member_birth;
	private String refund_bank;
	private String refund_account;
	private Date refund_applyDate; //환급 신청날짜
	private Date refund_completeDate; //환급 성사 날짜
	private int refund_StatusYN; //환급 금액 지불 상태
	
	public Refund() {
		
	}

	public Refund(int refund_no, int member_code, int refund_money, String member_name, String member_birth,
			String refund_bank, String refund_account, Date refund_applyDate, Date refund_completeDate,
			int refund_StatusYN) {
		super();
		this.refund_no = refund_no;
		this.member_code = member_code;
		this.refund_money = refund_money;
		this.member_name = member_name;
		this.member_birth = member_birth;
		this.refund_bank = refund_bank;
		this.refund_account = refund_account;
		this.refund_applyDate = refund_applyDate;
		this.refund_completeDate = refund_completeDate;
		this.refund_StatusYN = refund_StatusYN;
	}

	public int getRefund_no() {
		return refund_no;
	}

	public void setRefund_no(int refund_no) {
		this.refund_no = refund_no;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public int getRefund_money() {
		return refund_money;
	}

	public void setRefund_money(int refund_money) {
		this.refund_money = refund_money;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_birth() {
		return member_birth;
	}

	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}

	public String getRefund_bank() {
		return refund_bank;
	}

	public void setRefund_bank(String refund_bank) {
		this.refund_bank = refund_bank;
	}

	public String getRefund_account() {
		return refund_account;
	}

	public void setRefund_account(String refund_account) {
		this.refund_account = refund_account;
	}

	public Date getRefund_applyDate() {
		return refund_applyDate;
	}

	public void setRefund_applyDate(Date refund_applyDate) {
		this.refund_applyDate = refund_applyDate;
	}

	public Date getRefund_completeDate() {
		return refund_completeDate;
	}

	public void setRefund_completeDate(Date refund_completeDate) {
		this.refund_completeDate = refund_completeDate;
	}

	public int getRefund_StatusYN() {
		return refund_StatusYN;
	}

	public void setRefund_StatusYN(int refund_StatusYN) {
		this.refund_StatusYN = refund_StatusYN;
	}

	@Override
	public String toString() {
		return "Refund [refund_no=" + refund_no + ", member_code=" + member_code + ", refund_money=" + refund_money
				+ ", member_name=" + member_name + ", member_birth=" + member_birth + ", refund_bank=" + refund_bank
				+ ", refund_account=" + refund_account + ", refund_applyDate=" + refund_applyDate
				+ ", refund_completeDate=" + refund_completeDate + ", refund_StatusYN=" + refund_StatusYN + "]";
	}

	
	
	
}
