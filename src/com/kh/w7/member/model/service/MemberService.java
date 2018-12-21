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
		
		int result= new MemberDao().insertMember(con, reqMember);
			
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);	
			
		
		return result;
	}
	//아이디 중복검사
	public int idCheck(String inputId) {
		Connection con= getConnection();
		int result = new MemberDao().idCheck(con,inputId);
		close(con);
		return result;
		
		
	}

	

}
