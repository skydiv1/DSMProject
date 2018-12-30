package com.kh.w7.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.mypage.model.dao.MypageDao;
import com.kh.w7.mypage.model.vo.MyPage;
import static com.kh.w7.common.JDBCTemplate.*;

public class MypageService {

	public ArrayList<MyPage> selectList(int loginCode,int currentPage, int limit ) {
		Connection con = getConnection();
		
		ArrayList<MyPage> list = new MypageDao().selectList(con, loginCode,currentPage,limit);
		System.out.println("list값service:"+list);
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return list;
	}

	public int cancelUpdate(int dealnum, String textContent) {
		Connection con = getConnection();
		
		int result = new MypageDao().cancelUpdate(con,dealnum,textContent );
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int getListCount(int loginCode) {
		Connection con = getConnection();
		int listCount = new MypageDao().getListCount(con,loginCode);
		close(con);
		return listCount;
	}

	
	
	
	
}
