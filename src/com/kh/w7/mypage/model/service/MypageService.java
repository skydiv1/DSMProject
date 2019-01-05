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
		
		ArrayList<MyPage>CancelList = new MypageDao().selectCancelList(con, loginCode);
		
		if(CancelList != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return CancelList;
	}
	//취소목록에서 삭제
	public int cancelDelete(int dealnum) {
		
		Connection con = getConnection();
		
		int result = new MypageDao().cancelDelete(con,dealnum);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	//수락목록 조회
	public ArrayList<MyPage> selectAcceptList(int loginCode) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>appectlist =new MypageDao().selectAcceptList(con, loginCode);
		
		if(appectlist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return appectlist;
	}
	
	//소비자 구매완료 목록 조회
	public ArrayList<MyPage> selectDealList(int loginCode) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>deallist =new MypageDao().selectDealList(con, loginCode);
		
		if(deallist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return deallist;
	}
	//판매자 대기자 목록 조회
	public ArrayList<MyPage> selectWaitingList(int loginCode) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>waitlist = new MypageDao().selectWaitingList(con, loginCode);
		System.out.println("대기자목록 list service:"+waitlist);
		if(waitlist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return waitlist;
	}
	//판매자 거절할때
	public int cancelUpdateseller(int dealnum, String textContent) {
		Connection con = getConnection();
		
		int result = new MypageDao().cancelUpdateseller(con,dealnum,textContent );
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	//판매자 구매진행 목록
	public ArrayList<MyPage> selectdealprogressList(int loginCode) {
		
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>progresslist = new MypageDao().selectdealprogressList(con, loginCode);
		System.out.println("구매진행상황 list service:"+progresslist);
		if(progresslist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return progresslist;
	}
	
	//판매자 수락하기 버튼 누를때
	public int AgreelUpdateseller(int dealnum, String textContent) {
		Connection con = getConnection();
		
		int result = new MypageDao().AgreelUpdateseller(con,dealnum,textContent );
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;

	}
	//판매자 취소목록 조회
	public ArrayList<MyPage> selectSellerCancelList(int loginCode) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>sellerCancelList = new MypageDao().selectSellerCancelList(con, loginCode);
		
		if(sellerCancelList != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return sellerCancelList;
	}

	
	
	
	
}
