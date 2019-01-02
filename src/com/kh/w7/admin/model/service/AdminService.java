package com.kh.w7.admin.model.service;

import com.kh.w7.admin.model.dao.AdminDao;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.refund.model.vo.Refund;
import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


public class AdminService {

	public ArrayList<Refund> SelectAllRefundMember() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		ArrayList<Refund> list = new AdminDao().SelectAllRefundMember(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

	public int updateRefundStatus(int refundNo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = new AdminDao().updateRefundStatus(con, refundNo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		ArrayList<Member> list = new AdminDao().selectAllMember(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

	public int memberDelete(int memberCode) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = new AdminDao().memberDelete(con, memberCode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return result;
	}

	public int countPlusMinus(String what, int memberCode) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = new AdminDao().countPlusMinus(con, what, memberCode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return result;
	}

	public int memberLightOutF(int memberCode) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = new AdminDao().memberLightOutF(con, memberCode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int memberHeavyOutF(int memberCode) {

		Connection con = getConnection();
		
		int result = new AdminDao().memberHeavyOutF(con, memberCode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int memberRestoreF(int memberCode) {

		Connection con = getConnection();
		
		int result = new AdminDao().memberRestoreF(con, memberCode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int imgCert(int memberCode) {
		
		Connection con = getConnection();
		
		int result = new AdminDao().imgCert(con, memberCode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		
		
		return result;
	}

	public ArrayList<Board> selectAllBoard() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		ArrayList<Board> list = new ArrayList<Board>();
		list = new AdminDao().selectAllBoard(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

}
