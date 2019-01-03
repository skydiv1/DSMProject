package com.kh.w7.member.model.service;

import java.sql.Connection;

import com.kh.w7.member.model.dao.MemberDao;
import com.kh.w7.member.model.vo.Member;
import static com.kh.w7.common.JDBCTemplate.*;

public class MemberService {
	
	public Member loginCheck(Member reqMember) {
		Connection con = getConnection();
		Member loginUser = new MemberDao().logincheck(con,reqMember);
		close(con);
		return loginUser;
	}

	public int insertMember(Member reqMember) {
		Connection con = getConnection();
		
		int result= new MemberDao().insertSel(con, reqMember);
		int result2= new MemberDao().insertCon(con, reqMember);
			
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		

		return result;
	}
	//아이디 중복검사
	public int idCheck(String memberId) {
		Connection con= getConnection();
		int result = new MemberDao().idCheck(con,memberId);
		close(con);
		return result;
		
		
	}
	public int updateMember(Member reqMember) {
		Connection con = getConnection();
		
		int result= new MemberDao().updateMember(con, reqMember);
			
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);	
			
		
		return result;
	}

	public int findId(Member reqMember) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public int leaveMember(int memberStatus) {
		Connection con = getConnection();
		int result = new MemberDao().leaveMember(con,memberStatus);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return memberStatus;
		
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
		
		if(findpwd>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		System.out.println("service result:"+findpwd);
		return findpwd;
	}
	

}
