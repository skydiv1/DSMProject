package com.kh.w7.deal.model.service;

import static com.kh.w7.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.deal.model.dao.DealDao;
import com.kh.w7.deal.model.vo.Deal;

public class DealService {

	public ArrayList<Deal> selectOneProduct(int memberCode, int productNo) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		ArrayList<Deal> list = new ArrayList<Deal>();
		Deal d = new Deal();
		
		list = new DealDao().selectOneProduct(con, memberCode, productNo);
		System.out.println("serviceList : "+list);
		return list;
	}

}
