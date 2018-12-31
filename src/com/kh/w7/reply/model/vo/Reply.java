package com.kh.w7.reply.model.vo;

import java.sql.Date;

public class Reply implements java.io.Serializable{
	private int replyNo;
	private int boardNo;
	private int memberCode;
	private String replyContext;
	private Date replyDate;
	private int replyDelete;
	
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memberCode=" + memberCode + ", replyContext="
				+ replyContext + ", replyDate=" + replyDate + ", replyDelete=" + replyDelete + "]";
	}
	public Reply() {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memberCode = memberCode;
		this.replyContext = replyContext;
		this.replyDate = replyDate;
		this.replyDelete = replyDelete;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
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
	public String getReplyContext() {
		return replyContext;
	}
	public void setReplyContext(String replyContext) {
		this.replyContext = replyContext;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public int getReplyDelete() {
		return replyDelete;
	}
	public void setReplyDelete(int replyDelete) {
		this.replyDelete = replyDelete;
	}
	
	
}
