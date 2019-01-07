package com.kh.w7.deal.model.service;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.deal.model.dao.DealDao;
import com.kh.w7.deal.model.vo.Deal;

public class DealService {

	public ArrayList<Deal> selectOneProduct(int memberCode, int productNo, int dealnum) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ArrayList<Deal> list = new ArrayList<Deal>();
		Deal d = new Deal();
		
		list = new DealDao().selectOneProduct(con, memberCode, productNo, dealnum);
		//System.out.println("serviceList : "+list);
		return list;
	}

	public int updateCashDeal(int customerCode, int sellerCode, int dealNo, int totalPrice, int nowCash) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		int resultA = new DealDao().updateCashDeal(con, dealNo);
		int resultB = resultA + new DealDao().updateCustomerCash(con, customerCode, dealNo,  totalPrice, nowCash);
		int resultC = resultB + new DealDao().updateSellerCash(con, sellerCode, dealNo, totalPrice, nowCash);
		
		int result = resultC;
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}