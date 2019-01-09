package com.kh.w7.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.w7.mypage.model.dao.MypageDao;
import com.kh.w7.mypage.model.vo.MyPage;
import com.kh.w7.product.model.vo.Product;
import com.kh.w7.refund.model.vo.Refund;

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
	//신청 목록 페이징 처리
	public int getListCount(int loginCode) {
		Connection con = getConnection();
		int listCount = new MypageDao().getListCount(con,loginCode);
		close(con);
		return listCount;
	}

	//취소목록 조회
	public ArrayList<MyPage> selectCancelList(int loginCode, int currentPage, int limit) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>CancelList = new MypageDao().selectCancelList(con, loginCode,currentPage,limit);
		
		if(CancelList != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return CancelList;
	}
	//취소목록 페이징처리
	public int getCancelListCount(int loginCode) {
		Connection con = getConnection();
		int getCancelListCount = new MypageDao().getCancelListCount(con,loginCode);
		close(con);
		return getCancelListCount;
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
	public ArrayList<MyPage> selectAcceptList(int loginCode, int currentPage, int limit) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>acceptlist =new MypageDao().selectAcceptList(con, loginCode, currentPage, limit);
		
		if(acceptlist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return acceptlist;
	}
	//수락목록 페이징 처리
		public int getAccListCount(int loginCode) {
			Connection con = getConnection();
			int getAccListCount = new MypageDao().getAccListCount(con,loginCode);
			close(con);
			return getAccListCount;
		}
	
	//소비자 구매완료 목록 조회
	public ArrayList<MyPage> selectDealList(int loginCode, int currentPage, int limit) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>deallist =new MypageDao().selectDealList(con, loginCode, currentPage, limit);
		
		if(deallist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);

		return deallist;
	}
	//소비자 구매완료 목록 페이지
		public int getcomListCount(int loginCode) {
			Connection con = getConnection();
			int getcomListCount = new MypageDao().getcomListCount(con,loginCode);
			close(con);
			return getcomListCount;
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
		
		int result = new MypageDao().cancelUpdateseller(con,dealnum,textContent);
		
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
	
	//판매자 판매글 목록
	public ArrayList<Product> selectProductList(int loginCode) {
		Connection con  = getConnection(); 
		
		ArrayList<Product>productlist = new MypageDao().selectProductList(con, loginCode);
		
		if(productlist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return productlist;
	}
	//소비자 구매확정버튼
	public int completeUpdate(int dealnum) {
		Connection con = getConnection();
		
		int result = new MypageDao().completeUpdate(con,dealnum);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	//판매자 판매완료 목록
	public ArrayList<MyPage> selectendDealList(int loginCode) {
		Connection con  = getConnection(); 
		
		ArrayList<MyPage>endlist = new MypageDao().selectendDealList(con, loginCode);
		System.out.println("판매완료값service:"+endlist);
		if(endlist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return endlist;
	}
	//판매자 환급목록
	public ArrayList<Refund> selectCashList(int loginCode) {
		
		Connection con  = getConnection(); 
		
		ArrayList<Refund>cashlist = new MypageDao().selectCashList(con, loginCode);

		if(cashlist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return cashlist;
	}
	//리뷰정보 불러오기
	public ArrayList<HashMap<String, Object>> reviewSeller(int dealnum) {
		Connection con  = getConnection(); 
		
		ArrayList<HashMap<String, Object>>reviewlist = new MypageDao().reviewSeller(con, dealnum);

		if(reviewlist != null) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return reviewlist;
	}
	
	//리뷰 값 변경
	public int ReviewUpdate(int loginCode, int rstar, String rtext, int productNo) {

		Connection con = getConnection();
		
		int result = new MypageDao().ReviewUpdate(con,loginCode,rstar,rtext,productNo);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	//리뷰 상태 변경
	public int reviewStateUpdate(int dealnum) {
		
		Connection con = getConnection();
		
		int result = new MypageDao().reviewStateUpdate(con,dealnum);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}
	
	


	
	
	
	
}
