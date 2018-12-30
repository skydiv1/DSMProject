package com.kh.w7.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.mypage.model.dao.MypageDao;
import com.kh.w7.mypage.model.vo.MyPage;
import static com.kh.w7.common.JDBCTemplate.*;

public class MypageService {

	public ArrayList<MyPage> selectList(int loginCode) {
		Connection con = getConnection();
		
		ArrayList<MyPage> list = new MypageDao().selectList(con, loginCode);
		System.out.println("list값service:"+list);
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return list;
	}

	public int cancelUpdate(int loginCode, int no, String textContent) {
		Connection con = getConnection();
		
		int result = new MypageDao().cancelUpdate(con, loginCode, no,textContent );
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	
	
}
