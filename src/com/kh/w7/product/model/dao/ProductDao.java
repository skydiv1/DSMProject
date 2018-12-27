package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.w7.common.Attachment;
import com.kh.w7.member.model.vo.Member;
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
	/*public ArrayList<Product> selectList(Connection con, int currentPage, int limit) {
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
	}*/
	public ArrayList<HashMap<String, Object>> selecImagetList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("selectImageList");
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; // 조회할 때 시작할 행 번호
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>(); // 맴버 객체 대신 hashmap 사용 / Object: 다형성,autoBoxing 처리
				
				hmap.put("imgNo", rset.getInt("IMG_NO")); // 오토박싱 처리로 코드를 줄일 수 있다. 
				hmap.put("originName", rset.getString("ORIGINNAME"));
				hmap.put("changeName", rset.getString("CHANGENAME"));
				hmap.put("imgCategoy", rset.getInt("IMG_CATEGORY"));
				//hmap.put("sellerCertName", rset.getString("SELLERCERT_NAME"));
				hmap.put("memberCode", rset.getInt("MEMBER_CODE"));
				//hmap.put("boardNo", rset.getInt("BOARD_NO"));
				hmap.put("productNo", rset.getInt("PRODUCT_NO"));
				hmap.put("imgFilePath", rset.getString("IMG_FILEPATH"));
				hmap.put("imgDelete", rset.getInt("IMG_DELETE"));
				hmap.put("imgLevel", rset.getInt("IMG_LEVEL"));
				
				hmap.put("productName", rset.getString("PRODUCT_NAME"));
				hmap.put("productCategory", rset.getString("PRODUCT_CATEGORY"));
				hmap.put("productItem", rset.getString("PRODUCT_ITEM"));
				hmap.put("productItemPrice", rset.getInt("PRODUCT_ITEMPRICE"));
				hmap.put("productContext", rset.getString("PRODUCT_CONTEXT"));
				hmap.put("productRegisterDate", rset.getDate("PRODUCT_REGISTERDATE"));
				hmap.put("productDeleteYN", rset.getInt("PRODUCT_DELETEYN"));				
				
				list.add(hmap);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 자원반납
			close(pstmt);
			close(rset);
		}
		System.out.println("이미지 리스트: "+list);
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
	public int insertPlusProduct(Connection con, ArrayList<PlusProduct> pList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPlusProduct");
				
		try {
			for(int i=0; i<pList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, pList.get(i).getProductNo());
				pstmt.setString(2, pList.get(i).getPlusProductItem());
				pstmt.setInt(3, pList.get(i).getPlusProductPrice());
				
				result += pstmt.executeUpdate(); // 누적 연산으로 합쳐준다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("plusProduct.size(크기확인..): "+pList.size()); // 3
		System.out.println("plusProduct에 값이 들어오는지.. : "+pList);
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
				//pstmt.setInt(3, fileList.get(i).getProductNo());

				int level = 0;
				if(i==0) level=0;
				else level=1;
				pstmt.setInt(3, level);
				pstmt.setString(4, fileList.get(i).getImgFilePath());
				
				result += pstmt.executeUpdate(); // 누적 연산으로 합쳐준다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("insertAttachment(result값): "+result);
		
		return result;
	}


	/* 상품 목록에서 상품 상세보기 페이지로 이동 */
	public HashMap<String, Object> selectThumbnailMap(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		
		Product product = null;
		Attachment at = null;
		Member member = null;
		PlusProduct plusProduct = null;
		ArrayList<Attachment> list = null;
		ArrayList<PlusProduct> plist = null;
		
		String query = prop.getProperty("selectImageOne");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
		
			rset = pstmt.executeQuery();

			list = new ArrayList<Attachment>(); // 초기화 
			plist = new ArrayList<PlusProduct>(); 
			
			int count=0; // plusProduct: 3번까지만 들어가게 막아줘야 한다.
			while(rset.next()) { // 꺼낼 때는 product 6개(덮어쓰기로 결과적으로 1개) attachment 6개
				product = new Product();
				product.setProductNo(rset.getInt("PRODUCT_NO"));
				product.setMemberCode(rset.getInt("MEMBER_CODE"));
				product.setProductName(rset.getString("PRODUCT_NAME"));
				product.setProductCategory(rset.getString("PRODUCT_CATEGORY"));
				product.setProductItem(rset.getString("PRODUCT_ITEM"));
				product.setProductItemPrice(rset.getInt("PRODUCT_ITEMPRICE"));
				product.setProductContext(rset.getString("PRODUCT_CONTEXT"));
				product.setRegisterDate(rset.getDate("PRODUCT_REGISTERDATE"));
				product.setDeleteYN(rset.getInt("PRODUCT_DELETEYN"));
				
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));

				plusProduct = new PlusProduct();
				if(count==0) {
					plusProduct.setProductNo(rset.getInt("PRODUCT_NO"));
					plusProduct.setPlusProductItem(rset.getString("PLUSPRODUCT_ITEM"));
					plusProduct.setPlusProductPrice(rset.getInt("PLUSPRODUCT_PRICE"));
					plist.add(plusProduct);	
				} if(count==6) {
					plusProduct.setProductNo(rset.getInt("PRODUCT_NO"));
					plusProduct.setPlusProductItem(rset.getString("PLUSPRODUCT_ITEM"));
					plusProduct.setPlusProductPrice(rset.getInt("PLUSPRODUCT_PRICE"));
					plist.add(plusProduct);					
				} if(count==13) {
					plusProduct.setProductNo(rset.getInt("PRODUCT_NO"));
					plusProduct.setPlusProductItem(rset.getString("PLUSPRODUCT_ITEM"));
					plusProduct.setPlusProductPrice(rset.getInt("PLUSPRODUCT_PRICE"));
					plist.add(plusProduct);					
				}
				
				at = new Attachment();
				at.setImgNo(rset.getInt("IMG_NO"));
				at.setOriginName(rset.getString("ORIGINNAME"));
				at.setChangeName(rset.getString("CHANGENAME"));
				at.setImgCategory(rset.getInt("IMG_CATEGORY"));
				at.setMemberCode(rset.getInt("MEMBER_CODE"));
				at.setProductNo(rset.getInt("PRODUCT_NO"));
				at.setImgLevel(rset.getInt("IMG_LEVEL"));
				at.setImgFilePath(rset.getString("IMG_FILEPATH"));
				at.setImgDelete(rset.getInt("IMG_DELETE"));

				list.add(at);
				
				count++;
			}
			System.out.println("몇 번 카운트 됐는지 확인: "+count);			
			
			hmap = new HashMap<String, Object>();
			
			hmap.put("product", product);
			hmap.put("attachment", list);
			hmap.put("member", member);
			hmap.put("plusProduct", plist);
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		
		System.out.println("hmap확인: "+hmap);
		
		return hmap;
	}





}
