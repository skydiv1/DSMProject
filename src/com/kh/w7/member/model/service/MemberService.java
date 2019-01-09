package com.kh.w7.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.common.Attachment;
import com.kh.w7.member.model.dao.MemberDao;

import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.dao.ProductDao;

import static com.kh.w7.common.JDBCTemplate.*;

public class MemberService {

	public Member loginCheck(Member reqMember) {
		Connection con = getConnection();
		Member loginUser = new MemberDao().logincheck(con, reqMember);
		close(con);
		return loginUser;
	}

	/*
	 * public int insertMember(Member reqMember) { Connection con = getConnection();
	 * 
	 * int result= new MemberDao().insertSel(con, reqMember); int result2= new
	 * MemberDao().insertCon(con, reqMember);
	 * 
	 * if(result>0) { commit(con); }else { rollback(con); } close(con);
	 * 
	 * 
	 * return result; }
	 */
	
	/* 회원가입()이미지 포힘 */
	public int insertSel(Member reqMember, ArrayList<Attachment> fileList) {
		Connection con = getConnection();

		int result=0;
		
		int result1 = new MemberDao().insertSel(con, reqMember);
		if(result1>0) {
			int currNum = new MemberDao().selectCurrval(con);
		
			for(int i=0; i<fileList.size(); i++) { 
				fileList.get(i).setMemberCode(currNum); 
			}
		}
		
		int result2 = new MemberDao().insertAttachment(con, fileList);
		
		if (result1 > 0 && result2 > 0) {
			result=1;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int insertCon(Member reqMember) {
		Connection con = getConnection();

		int result = new MemberDao().insertCon(con, reqMember);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	// 아이디 중복검사
	public int idCheck(String memberId) {
		Connection con = getConnection();
		int result = new MemberDao().idCheck(con, memberId);
		close(con);
		return result;

	}

	public int updateMember(Member reqMember) {
		Connection con = getConnection();

		int result = new MemberDao().updateMember(con, reqMember);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int findId(Member reqMember) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int leaveMember(int memberCode) {
		Connection con = getConnection();
		System.out.println("service입니다");
		int result = new MemberDao().leaveMember(con, memberCode);

		System.out.println("service result: "+result);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;

	}

	public String find(String memberName, String memberEmail) {
		Connection con = getConnection();

		String memberId = new MemberDao().findid(con, memberName, memberEmail);

		close(con);

		return memberId;
	}

	public int findpwd(String randomCode, String memberId, String memberEmail, String memberName) {
		Connection con = getConnection();

		int findpwd = new MemberDao().findpwd(con, memberName, memberId, memberEmail, randomCode);

		if (findpwd > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		System.out.println("service result:" + findpwd);
		return findpwd;
	}

	
	public int findmemberCode(Member reqMember) {
		Connection con = getConnection();
		
		int result= new MemberDao().findmemberCode(con,reqMember);
		
		close(con);
		
		return result;
	}
	

	public int insertImg(ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertImg(con, fileList);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	
}
