package com.kh.w7.board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int boardNo;
	private int memberCode;
	private String boardTitle;
	private String boardContext;
	private Date boardDate;
	private int boardCategory;
	private int boardCount;
	private int boardDelete;
	private String memberName;
	private int boardQnaAnswerYn;
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public int getBoardQnaAnswerYn() {
		return boardQnaAnswerYn;
	}
	public void setBoardQnaAnswerYn(int boardQnaAnswerYn) {
		this.boardQnaAnswerYn = boardQnaAnswerYn;
	}
	
	public int getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContext() {
		return boardContext;
	}
	public void setBoardContext(String boardContext) {
		this.boardContext = boardContext;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(int boardCategory) {
		this.boardCategory = boardCategory;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public int getBoardDelete() {
		return boardDelete;
	}
	public void setBoardDelete(int boardDelete) {
		this.boardDelete = boardDelete;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", memberCode=" + memberCode + ", boardTitle=" + boardTitle
				+ ", boardContext=" + boardContext + ", boardDate=" + boardDate + ", boardCategory=" + boardCategory
				+ ", boardCount=" + boardCount + ", boardDelete=" + boardDelete + ", memberName=" + memberName + "]";
	}
	public Board() {
		super();
		this.boardNo = boardNo;
		this.memberCode = memberCode;
		this.boardTitle = boardTitle;
		this.boardContext = boardContext;
		this.boardDate = boardDate;
		this.boardCategory = boardCategory;
		this.boardCount = boardCount;
		this.boardDelete = boardDelete;
		this.memberName = memberName;
	}
	
	

	
	
	
	

}
