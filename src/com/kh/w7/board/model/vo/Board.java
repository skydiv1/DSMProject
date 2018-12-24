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

	public Board() {}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", memberCode=" + memberCode + ", boardTitle=" + boardTitle
				+ ", boardContext=" + boardContext + ", boardDate=" + boardDate + ", boardCategory=" + boardCategory
				+ ", boardCount=" + boardCount + ", boardDelete=" + boardDelete + "]";
	}

	public Board(int boardNo, int memberCode, String boardTitle, String boardContext, Date boardDate, int boardCategory,
			int boardCount, int boardDelete) {
		super();
		this.boardNo = boardNo;
		this.memberCode = memberCode;
		this.boardTitle = boardTitle;
		this.boardContext = boardContext;
		this.boardDate = boardDate;
		this.boardCategory = boardCategory;
		this.boardCount = boardCount;
		this.boardDelete = boardDelete;
	}
	

	
	
	
	
	

}
