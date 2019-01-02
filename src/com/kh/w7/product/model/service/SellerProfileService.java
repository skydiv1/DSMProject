package com.kh.w7.product.model.service;

import static com.kh.w7.common.JDBCTemplate.close;
import static com.kh.w7.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.w7.product.model.dao.ProductDao;
import com.kh.w7.product.model.dao.SellerProfileDao;
import com.kh.w7.product.model.vo.Product;

public class SellerProfileService {

	public HashMap<String, Object> selectSellerList(int memberCode, int currentPage, int limit) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = new SellerProfileDao().selectSellerList(con, memberCode, currentPage, limit);
		
		close(con);
		
		return hmap;
	}

}
