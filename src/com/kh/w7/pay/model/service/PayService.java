package com.kh.w7.pay.model.service;

import com.kh.w7.pay.model.dao.PayDao;
import com.kh.w7.pay.model.vo.Pay;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;

public class PayService {

	public int insertPay(Pay p) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		//pay테이블에 결제 한 값을 넣고 맴버캐시테이블에도 넣기
		int resultA = new PayDao().insertPay(con, p);
		int resultB = new PayDao().insertMemberCash(con,p);
		int result = resultA + resultB;
		
		System.out.println("resultA : " + resultA);
		System.out.println("resultB : " + resultB);
		System.out.println("result : " + result);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);

		}
		close(con);
		
		return result;
	}

	public int selectMemberNowCash(int memberCode) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int nowCash = new PayDao().selectMemberNowCash(con, memberCode);
		
		if(nowCash > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return nowCash;
	}

}
