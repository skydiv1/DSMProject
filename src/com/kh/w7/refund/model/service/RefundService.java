package com.kh.w7.refund.model.service;

import java.sql.Connection;
import static com.kh.w7.common.JDBCTemplate.*;

import com.kh.w7.pay.model.dao.PayDao;
import com.kh.w7.refund.model.dao.RefundDao;
import com.kh.w7.refund.model.vo.Refund;

public class RefundService {

	public int insertRefundData(Refund r) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int resultA = new RefundDao().insertRefundData(con, r); //refund테이블에 값넣기
		int resultB = new RefundDao().insertRefundListData(con, r); //refundList테이블에 값 넣기
		int resultC = new RefundDao().insertMemberCashRefundData(con, r); //membercash테이블에 값 넣기
		
		System.out.println("resultA : " + resultA);
		System.out.println("resultB : " + resultB);
		System.out.println("resultC : " + resultC);
		
		int result = resultA + resultB + resultC;
		System.out.println("result : " + result);
		
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		//System.out.println("service result : " + result);
		return result;
	}
	
	
	public int selectMemberNowCash(int memberCode) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int nowCash = new RefundDao().selectMemberNowCash(con, memberCode);
		
		if(nowCash > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return nowCash;
	}
	
	
	

}
