package com.kh.w7.member.model.vo;

public class Member implements java.io.Serializable {
	private int memberCode;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private int memberCategory;
	private String sellerIntroduction;
	private int sellerGrade;
	private String sellerCareer;
	private int memberAdmin;
	private int memberStatus;
	private String sellerAccountName;
	private String sellerBank;
	private String sellerAccount;
	private int sellerCertcheck;
	private int blackCount;
	
	public Member() {}


	

	public Member(int memberCode, String memberId, String memberPwd, String memberName, String memberPhone,
			String memberEmail, int memberCategory, String sellerIntroduction, int sellerGrade, String sellerCareer,
			int memberAdmin, int memberStatus, String sellerAccountName, String sellerBank, String sellerAccount,
			int sellerCertcheck) {
		super();
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberCategory = memberCategory;
		this.sellerIntroduction = sellerIntroduction;
		this.sellerGrade = sellerGrade;
		this.sellerCareer = sellerCareer;
		this.memberAdmin = memberAdmin;
		this.memberStatus = memberStatus;
		this.sellerAccountName = sellerAccountName;
		this.sellerBank = sellerBank;
		this.sellerAccount = sellerAccount;
		this.sellerCertcheck = sellerCertcheck;
	}




	public int getMemberCode() {
		return memberCode;
	}




	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	
	
	public int getblackCount() {
		return blackCount;
	}


	public void setblackCount(int blackCount) {
		this.blackCount = blackCount;
	}



	public String getMemberId() {
		return memberId;
	}




	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}




	public String getMemberPwd() {
		return memberPwd;
	}




	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}




	public String getMemberName() {
		return memberName;
	}




	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}




	public String getMemberPhone() {
		return memberPhone;
	}




	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}




	public String getMemberEmail() {
		return memberEmail;
	}




	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}




	public int getMemberCategory() {
		return memberCategory;
	}




	public void setMemberCategory(int memberCategory) {
		this.memberCategory = memberCategory;
	}




	public String getSellerIntroduction() {
		return sellerIntroduction;
	}




	public void setSellerIntroduction(String sellerIntroduction) {
		this.sellerIntroduction = sellerIntroduction;
	}




	public int getSellerGrade() {
		return sellerGrade;
	}




	public void setSellerGrade(int sellerGrade) {
		this.sellerGrade = sellerGrade;
	}




	public String getSellerCareer() {
		return sellerCareer;
	}




	public void setSellerCareer(String sellerCareer) {
		this.sellerCareer = sellerCareer;
	}




	public int getMemberAdmin() {
		return memberAdmin;
	}




	public void setMemberAdmin(int memberAdmin) {
		this.memberAdmin = memberAdmin;
	}




	public int getmemberStatus() {
		return memberStatus;
	}




	public void setPrivatememberStatus(int memberStatus) {
		this.memberStatus = memberStatus;
	}




	public String getSellerAccountName() {
		return sellerAccountName;
	}




	public void setSellerAccountName(String sellerAccountName) {
		this.sellerAccountName = sellerAccountName;
	}




	public String getSellerBank() {
		return sellerBank;
	}




	public void setSellerBank(String sellerBank) {
		this.sellerBank = sellerBank;
	}




	public String getSellerAccount() {
		return sellerAccount;
	}




	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}




	public int getSellerCertcheck() {
		return sellerCertcheck;
	}




	public void setSellerCertcheck(int sellerCertcheck) {
		this.sellerCertcheck = sellerCertcheck;
	}




	@Override
	public String toString() {
		return "Member [memberCode=" + memberCode + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail
				+ ", memberCategory=" + memberCategory + ", sellerIntroduction=" + sellerIntroduction + ", sellerGrade="
				+ sellerGrade + ", sellerCareer=" + sellerCareer + ", memberAdmin=" + memberAdmin
				+ ", memberStatus=" + memberStatus + ", sellerAccountName=" + sellerAccountName
				+ ", sellerBank=" + sellerBank + ", sellerAccount=" + sellerAccount + ", sellerCertcheck="
				+ sellerCertcheck + "]";
	}





}
