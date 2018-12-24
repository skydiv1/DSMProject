package com.kh.w7.pay.model.service;

import com.kh.w7.pay.model.dao.PayDao;
import com.kh.w7.pay.model.vo.Pay;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;

public class PayService {

	public int insertPay(Pay p) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = new PayDao().insertPay(con, p);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);

		}
		close(con);
		
		return result;
	}

}
