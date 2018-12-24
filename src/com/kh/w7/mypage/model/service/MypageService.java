package com.kh.w7.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.mypage.model.dao.MypageDao;
import com.kh.w7.mypage.model.vo.MyPage;
import static com.kh.w7.common.JDBCTemplate.*;

public class MypageService {

	public ArrayList<MyPage> selectList(int clogin) {
		Connection con = getConnection();
		
		ArrayList<MyPage> list = new MypageDao().selectList(con, clogin);
		
		if(list != null) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return list;
	}

	
}
