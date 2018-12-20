package com.kh.w7.member.model.vo;

public class Member implements java.io.Serializable {
	private int member_code;
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String member_phone;
	private String member_email;
	private int member_category;
	private String seller_introduction;
	private int seller_grade;
	private String seller_career;
	private int member_admin;
	private int privatemember_status;
	private String seller_accountName;
	private String seller_bank;
	private String seller_account;
	
	public Member() {}

	public Member(int member_code, String member_id, String member_pwd, String member_name, String member_phone,
			String member_email, int member_category, String seller_introduction, int seller_grade,
			String seller_career, int member_admin, int privatemember_status, String seller_accountNane,
			String seller_bank, String seller_account) {
		super();
		this.member_code = member_code;
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.member_category = member_category;
		this.seller_introduction = seller_introduction;
		this.seller_grade = seller_grade;
		this.seller_career = seller_career;
		this.member_admin = member_admin;
		this.privatemember_status = privatemember_status;
		this.seller_accountName = seller_accountName;
		this.seller_bank = seller_bank;
		this.seller_account = seller_account;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public int getMember_category() {
		return member_category;
	}

	public void setMember_category(int member_category) {
		this.member_category = member_category;
	}

	public String getSeller_introduction() {
		return seller_introduction;
	}

	public void setSeller_introduction(String seller_introduction) {
		this.seller_introduction = seller_introduction;
	}

	public int getSeller_grade() {
		return seller_grade;
	}

	public void setSeller_grade(int seller_grade) {
		this.seller_grade = seller_grade;
	}

	public String getSeller_career() {
		return seller_career;
	}

	public void setSeller_career(String seller_career) {
		this.seller_career = seller_career;
	}

	public int getMember_admin() {
		return member_admin;
	}

	public void setMember_admin(int member_admin) {
		this.member_admin = member_admin;
	}

	public int getPrivatemember_status() {
		return privatemember_status;
	}

	public void setPrivatemember_status(int privatemember_status) {
		this.privatemember_status = privatemember_status;
	}

	public String getSeller_accountName() {
		return seller_accountName;
	}

	public void setSeller_accountName(String seller_accountName) {
		this.seller_accountName = seller_accountName;
	}

	public String getSeller_bank() {
		return seller_bank;
	}

	public void setSeller_bank(String seller_bank) {
		this.seller_bank = seller_bank;
	}

	public String getSeller_account() {
		return seller_account;
	}

	public void setSeller_account(String seller_account) {
		this.seller_account = seller_account;
	}

	@Override
	public String toString() {
		return "Member [member_code=" + member_code + ", member_id=" + member_id + ", member_pwd=" + member_pwd
				+ ", member_name=" + member_name + ", member_phone=" + member_phone + ", member_email=" + member_email
				+ ", member_category=" + member_category + ", seller_introduction=" + seller_introduction
				+ ", seller_grade=" + seller_grade + ", seller_career=" + seller_career + ", member_admin="
				+ member_admin + ", privatemember_status=" + privatemember_status + ", seller_accountName="
				+ seller_accountName + ", seller_bank=" + seller_bank + ", seller_account=" + seller_account + "]";
	}
	
	



	
}
