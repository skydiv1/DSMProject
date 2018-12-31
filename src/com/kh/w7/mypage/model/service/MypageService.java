package com.kh.w7.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.mypage.model.dao.MypageDao;
import com.kh.w7.mypage.model.vo.MyPage;
import static com.kh.w7.common.JDBCTemplate.*;

public class MypageService {

	//신청목록 조회
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
	//취소 버튼 눌렀을 때 
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
	//페이징 처리
	public int getListCount(int loginCode) {
		Connection con = getConnection();
		int listCount = new MypageDao().getListCount(con,loginCode);
		close(con);
		return listCount;
	}

	//취소목록 조회
	public ArrayList<MyPage> selectCancelList(int loginCode) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>CancelList = MypageDao.selectCancelList(con, loginCode);
		
		if(CancelList != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return CancelList;
	}

	
	
	
	
}
