package com.kh.w7.member.model.vo;

public class Img {
	private int img_no;
	private String originname;
	private String changename;
	private int img_category;
	private String sellercert_name;
	private int member_code;
	private int board_no;
	private int product_no;
	private int img_level;
	private String img_filepath;
	private int img_delete;
	
	public  Img() {
		super();
	}

	public Img(int img_no, String originname, String changename, int img_category, String sellercert_name,
			int member_code, int board_no, int product_no, int img_level, String img_filepath, int img_delete) {
		super();
		this.img_no = img_no;
		this.originname = originname;
		this.changename = changename;
		this.img_category = img_category;
		this.sellercert_name = sellercert_name;
		this.member_code = member_code;
		this.board_no = board_no;
		this.product_no = product_no;
		this.img_level = img_level;
		this.img_filepath = img_filepath;
		this.img_delete = img_delete;
	}

	public int getImg_no() {
		return img_no;
	}

	public void setImg_no(int img_no) {
		this.img_no = img_no;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getChangename() {
		return changename;
	}

	public void setChangename(String changename) {
		this.changename = changename;
	}

	public int getImg_category() {
		return img_category;
	}

	public void setImg_category(int img_category) {
		this.img_category = img_category;
	}

	public String getSellercert_name() {
		return sellercert_name;
	}

	public void setSellercert_name(String sellercert_name) {
		this.sellercert_name = sellercert_name;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getImg_level() {
		return img_level;
	}

	public void setImg_level(int img_level) {
		this.img_level = img_level;
	}

	public String getImg_filepath() {
		return img_filepath;
	}

	public void setImg_filepath(String img_filepath) {
		this.img_filepath = img_filepath;
	}

	public int getImg_delete() {
		return img_delete;
	}

	public void setImg_delete(int img_delete) {
		this.img_delete = img_delete;
	}

	@Override
	public String toString() {
		return "Img [img_no=" + img_no + ", originname=" + originname + ", changename=" + changename + ", img_category="
				+ img_category + ", sellercert_name=" + sellercert_name + ", member_code=" + member_code + ", board_no="
				+ board_no + ", product_no=" + product_no + ", img_level=" + img_level + ", img_filepath="
				+ img_filepath + ", img_delete=" + img_delete + "]";
	}

	

	
	

}
