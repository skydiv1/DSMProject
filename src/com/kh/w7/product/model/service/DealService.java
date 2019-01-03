package com.kh.w7.product.model.service;

import static com.kh.w7.common.JDBCTemplate.close;
import static com.kh.w7.common.JDBCTemplate.commit;
import static com.kh.w7.common.JDBCTemplate.getConnection;
import static com.kh.w7.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.w7.deal.model.vo.Deal;
import com.kh.w7.product.model.dao.DealDao;

public class DealService {

	public int insertDeal(Deal deal) {
		Connection con = getConnection();
		
		int result = new DealDao().insertDeal(con, deal);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

}
