package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.vo.Product;

public class SellerProfileDao {
	private Properties prop = new Properties();

	public SellerProfileDao() {
		String fileName = ProductDao.class.getResource("/sql/sellerProfile/sellerProfile-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> selectSellerList(Connection con, int memberCode) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;

		String query = prop.getProperty("selectList");
		//System.out.println("query: "+query);
		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);

			list = new ArrayList<Product>();

			while (rset.next()) {
				Product product = new Product();
				
				product.setProductNo(rset.getInt("PRODUCT_NO"));
				product.setMemberCode(rset.getInt("MEMBER_CODE"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductCategory(rset.getString("PRODUCT_CATEGORY"));
				product.setProductItem(rset.getString("PRODUCT_ITEM"));
				product.setProductItemPrice(rset.getInt("PRODUCT_ITEMPRICE"));
				product.setProductContext(rset.getString("PRODUCT_CONTEXT"));
				product.setRegisterDate(rset.getDate("PRODUCT_REGISTERDATE"));
				product.setDeleteYN(rset.getInt("PRODUCT_DELETEYN"));

				list.add(product); // product를 담는다.
				
				
				Member member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setSellerIntroduction(rset.getString("SELLER_INTRODUCTION"));
				member.setSellerGrade(rset.getInt("SELLER_GRADE"));
				member.setSellerCareer(rset.getString("SELLER_CAREER"));
				
			}
			System.out.println("productDao(selectList) :  "+list);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		return list;
	}

}
