package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.w7.common.Attachment;
import com.kh.w7.product.model.vo.PlusProduct;
import com.kh.w7.product.model.vo.Product;

public class ProductDao {
	private Properties prop = new Properties();

	public ProductDao() {
		String fileName = ProductDao.class.getResource("/sql/product/product-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 상품 목록 페이지 */
	public ArrayList<Product> selectList(Connection con) {
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


	/* 전체 게시글 수 조회 */
	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		System.out.println("listCount(게시물 총 개수) : "+listCount);
		return listCount;
	}


	/* 상품 목록 페이지 조회(페이징처리) */
	public ArrayList<Product> selectList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; // 조회할 때 시작할 행 번호
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Product>();
			
			while(rset.next()) {
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
			}
			System.out.println("list에 값이 들어오는지.. :"+list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	
	/* 내용만 insert / 부모 테이블 먼저 insert 해야 한다. */
	public int insertThumbnailContent(Connection con, Product product) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertThumb");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getProductCategory());
			pstmt.setString(3, product.getProductItem());
			pstmt.setInt(4, product.getProductItemPrice());
			pstmt.setString(5, product.getProductContext());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	/* 현재 시퀀스 값 조회 */
	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset =null;
		
		int currNum=0;
		
		String query = prop.getProperty("selectCurrval"); // 현재 동작한 시퀀스 번호를 알 수 있다.
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				currNum = rset.getInt("CURRVAL");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt); // Connection을 닫으면 안된다. service에서 트랜젝션 처리를 해 줄 수 없다
		}
		
		return currNum;
	}

	
	/* 상품 추가 목록에 데이터 삽입 */
	public int insertPlusProduct(Connection con, ArrayList<PlusProduct> plusProduct) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPlusProduct");
				
		try {
			for(int i=0; i<plusProduct.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, plusProduct.get(i).getProductNo());
				pstmt.setString(2, plusProduct.get(i).getPlusProductItem());
				pstmt.setInt(3, plusProduct.get(i).getPlusProductPrice());
				
				result += pstmt.executeUpdate(); // 누적 연산으로 합쳐준다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("plusProduct.size(크기확인..): "+plusProduct.size()); // 3
		System.out.println("plusProduct에 값이 들어오는지.. : "+plusProduct);
		System.out.println("insertPlusProduct(result값): "+result);
		return result;
	}


	/* 상품 등록 페이지(이미지 첨부 포함) */
	public int insertAttachment(Connection con, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		
		try {
			for(int i=0; i<fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2, fileList.get(i).getChangeName());
				pstmt.setInt(3, fileList.get(i).getProductNo());
				pstmt.setString(4, fileList.get(i).getImgFile());
				
				result += pstmt.executeUpdate(); // 누적 연산으로 합쳐준다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


}
