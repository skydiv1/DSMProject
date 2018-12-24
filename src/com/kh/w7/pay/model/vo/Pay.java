package com.kh.w7.pay.model.vo;

import java.sql.Date;

public class Pay implements java.io.Serializable{
	private int pay_no;
	private int member_code;
	private Date pay_date;
	private int pay_price;
	
	
	public Pay() {
		
	}
	
	public Pay(int pay_no, int member_code, Date pay_date, int pay_price) {
		super();
		this.pay_no = pay_no;
		this.member_code = member_code;
		this.pay_date = pay_date;
		this.pay_price = pay_price;
	}

	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}
	public int getMember_code() {
		return member_code;
	}
	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}

	@Override
	public String toString() {
		return "Pay [pay_no=" + pay_no + ", member_code=" + member_code + ", pay_date=" + pay_date + ", pay_price="
				+ pay_price + "]";
	}
	
}
