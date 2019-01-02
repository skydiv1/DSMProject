package com.kh.w7.product.model.service;

import static com.kh.w7.common.JDBCTemplate.close;
import static com.kh.w7.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.w7.product.model.dao.SellerProfileDao;
import com.kh.w7.product.model.vo.Product;

public class SellerProfileService {

	public ArrayList<Product> selectSellerList(int memberCode) {
		Connection con = getConnection();
		
		ArrayList<Product> productList = null;
		
		productList = new SellerProfileDao().selectSellerList(con, memberCode);
		
		close(con);
		
		System.out.println("productList(service)확인: "+productList);
		
		return productList;
	}

}
