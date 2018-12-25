package com.kh.w7.common;

public class Attachment implements java.io.Serializable{
	private int imgNo;					// 이미지 번호
	private String originName;		// 기존이름
	private String changeName;		// 바뀐이름
	private int imgCategory;			// 사진분류
	private String sellerCertName;	// 판매자 자격증 이름
	private int memberCode;			// 회원코드
	private int boardNo;				// 글번호
	private int productNo;				// 상품번호
	private int imgLevel;				// 이미지 레벨
	private String imgFilePath;		// 이미지 경로
	private int imgDelete;				// 삭제여부

	public Attachment() {}

	public Attachment(int imgNo, String originName, String changeName, int imgCategory, String sellerCertName,
			int memberCode, int boardNo, int productNo, int imgLevel, String imgFilePath, int imgDelete) {
		super();
		this.imgNo = imgNo;
		this.originName = originName;
		this.changeName = changeName;
		this.imgCategory = imgCategory;
		this.sellerCertName = sellerCertName;
		this.memberCode = memberCode;
		this.boardNo = boardNo;
		this.productNo = productNo;
		this.imgLevel = imgLevel;
		this.imgFilePath = imgFilePath;
		this.imgDelete = imgDelete;
	}

	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public int getImgCategory() {
		return imgCategory;
	}

	public void setImgCategory(int imgCategory) {
		this.imgCategory = imgCategory;
	}

	public String getSellerCertName() {
		return sellerCertName;
	}

	public void setSellerCertName(String sellerCertName) {
		this.sellerCertName = sellerCertName;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getImgLevel() {
		return imgLevel;
	}

	public void setImgLevel(int imgLevel) {
		this.imgLevel = imgLevel;
	}

	public String getImgFilePath() {
		return imgFilePath;
	}

	public void setImgFilePath(String imgFilePath) {
		this.imgFilePath = imgFilePath;
	}

	public int getImgDelete() {
		return imgDelete;
	}

	public void setImgDelete(int imgDelete) {
		this.imgDelete = imgDelete;
	}

	@Override
	public String toString() {
		return "Attachment [imgNo=" + imgNo + ", originName=" + originName + ", changeName=" + changeName
				+ ", imgCategory=" + imgCategory + ", sellerCertName=" + sellerCertName + ", memberCode=" + memberCode
				+ ", boardNo=" + boardNo + ", productNo=" + productNo + ", imgLevel=" + imgLevel + ", imgFilePath="
				+ imgFilePath + ", imgDelete=" + imgDelete + "]";
	}
}
