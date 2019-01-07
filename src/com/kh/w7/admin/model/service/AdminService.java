package com.kh.w7.admin.model.service;

import com.kh.w7.admin.model.dao.AdminDao;
import com.kh.w7.admin.model.vo.Admin;
import com.kh.w7.admin.model.vo.Cash;
import com.kh.w7.admin.model.vo.ProductExcel;
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

	public Admin refreshPage() {
		// TODO Auto-generated method stub
		Connection con  = getConnection();
		
		Admin ad = new Admin();
		int result = new AdminDao().procedureHomePage(con);
		ad = new AdminDao().refreshPage(con);
		System.out.println("프로시저result : " + result);
		if(ad != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		
		return ad;
	}

	public ArrayList<Cash> cashConvertExcel() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		ArrayList<Cash> list = new ArrayList<Cash>();
		
		list = new AdminDao().cashConvertExcel(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

	public ArrayList<ProductExcel> ProductConvertExcel() {
		
		Connection con = getConnection();
		
		ArrayList<ProductExcel> list = new ArrayList<ProductExcel>();
		
		list = new AdminDao().ProductConvertExcel(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

	public ArrayList<Member> MemberConvertExcel() {
		Connection con = getConnection();
		
		ArrayList<Member> list = new ArrayList<Member>();
		
		list = new AdminDao().MemberConvertExcel(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

	public ArrayList<Board> BoardConvertExcel() {
		Connection con = getConnection();
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		list = new AdminDao().BoardConvertExcel(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return list;
	}

	public ArrayList<Board> selectAllFaq() {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		ArrayList<Board> list = new ArrayList<Board>();
		list = new AdminDao().selectAllFaq(con);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return list;
	}

	public int deleteAdminFaq(int boardNo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		int result = 0;
		result = new AdminDao().deleteAdminFaq(con, boardNo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int restoreAdminFaq(int boardNo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		int result = 0;
		result = new AdminDao().restoreAdminFaq(con, boardNo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
