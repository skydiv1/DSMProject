package com.kh.w7.product.model.service;

import static com.kh.w7.common.JDBCTemplate.close;
import static com.kh.w7.common.JDBCTemplate.commit;
import static com.kh.w7.common.JDBCTemplate.getConnection;
import static com.kh.w7.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.w7.deal.model.vo.Deal;
import com.kh.w7.deal.model.vo.DealList;
import com.kh.w7.product.model.dao.DealDao;
import com.kh.w7.product.model.dao.ProductDao;

public class DealService {

	public int insertDeal(Deal deal, DealList dealList) {
		Connection con = getConnection();
		DealList dealList2 = null;
		
		int result = new DealDao().insertDeal(con, deal);
				
		if(result>0) {
			int nextNum = new DealDao().selectNextval(con); // 다음시퀀스 값 조회
			int currNum = new DealDao().selectCurrval(con); // 현재시퀀스 값 조회
			System.out.println("(insertDealList)현재시퀀시 값 조회: " + currNum); // SEQ_DEAL
			
			//dealList2 = new DealList();
			dealList.setDealNo(currNum);
			System.out.println("dealList.getDealNo(현재 시퀀스 값) : "+dealList.getDealNo());
		}
		int result2 = new DealDao().insertDealList(con, dealList);
		System.out.println("dealList 서비스 : "+dealList);
		if(result>0 && result2>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}


}
