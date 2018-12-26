package com.kh.w7.refund.model.service;

import java.sql.Connection;
import static com.kh.w7.common.JDBCTemplate.*;

import com.kh.w7.refund.model.dao.RefundDao;
import com.kh.w7.refund.model.vo.Refund;

public class RefundService {

	public int insertRefundData(Refund r) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = new RefundDao().insertRefundData(con, r);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		//System.out.println("service result : " + result);
		return result;
	}

}
