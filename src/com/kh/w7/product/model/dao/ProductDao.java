package com.kh.w7.product.model.dao;

import static com.kh.w7.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
		
		String query = prop.getProperty("insertProduct");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, product.getMemberCode());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getProductCategory());
			pstmt.setString(4, product.getProductItem());
			pstmt.setInt(5, product.getProductItemPrice());
			pstmt.setString(6, product.getProductContext());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("result(insertThumbnailContent) 업데이트 확인 : "+result);
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

	
	/* 다음 시퀀스 조회 */
	public int selectNextval(Connection con) {
		Statement stmt = null;
		ResultSet rset =null;
		
		int nextNum=0;
		
		String query = prop.getProperty("selectNextval"); // 현재 동작한 시퀀스 번호를 알 수 있다.
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				nextNum = rset.getInt("NEXTVAL");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt); // Connection을 닫으면 안된다. service에서 트랜젝션 처리를 해 줄 수 없다
		}
		
		return nextNum;
	}

	
	/* 이미지 테이블의 다음시퀀스 값 조회 */
	public int selectImgNextval(Connection con) {
		Statement stmt = null;
		ResultSet rset =null;
		
		int nextNum=0;
		
		String query = prop.getProperty("selectImgNextval"); // 현재 동작한 시퀀스 번호를 알 수 있다.
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				nextNum = rset.getInt("NEXTVAL");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt); // Connection을 닫으면 안된다. service에서 트랜젝션 처리를 해 줄 수 없다
		}
		
		return nextNum;
	}


	
	/* 상품 추가 목록에 데이터 삽입 */
	public int insertPlusProduct(Connection con, ArrayList<PlusProduct> pList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPlusProduct");
				
		try {
			for(int i=0; i<pList.size(); i++) {
				pstmt = con.prepareStatement(query);
				//pstmt.setInt(1, pList.get(i).getProductNo());
				pstmt.setString(1, pList.get(i).getPlusProductItem());
				pstmt.setInt(2, pList.get(i).getPlusProductPrice());
				
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
				//pstmt.setInt(1, fileList.get(i).getImgNo());
				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2, fileList.get(i).getChangeName());
				pstmt.setInt(3, fileList.get(i).getMemberCode());
				//pstmt.setInt(4, fileList.get(i).getProductNo()); // IMG_FK2

				int level = 0;
				if(i==0) level=0;
				else level=1;
				pstmt.setInt(4, level);
				pstmt.setString(5, fileList.get(i).getImgFilePath());
				
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

		HashMap<String, Object> queryMap = new HashMap<String, Object>();
		String query = prop.getProperty("selectImageOne"); // 이미지
		String query2 = prop.getProperty("selectPlusProductOne"); // 추가상품
		
		try {
			// Attachment -----------------------------------------
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
		
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			
			while(rset.next()) { 
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
			}
			System.out.println("DAO 이미지 리스트 : " + list);
						
			
			// PlusProduct -----------------------------------------
			pstmt = con.prepareStatement(query2);
			pstmt.setInt(1, num);
		
			rset = pstmt.executeQuery();
			
			plist = new ArrayList<PlusProduct>(); 
			
			while(rset.next()) {
				plusProduct = new PlusProduct();
				plusProduct.setProductNo(rset.getInt("PRODUCT_NO"));
				plusProduct.setPlusProductItem(rset.getString("PLUSPRODUCT_ITEM"));
				plusProduct.setPlusProductPrice(rset.getInt("PLUSPRODUCT_PRICE"));
				plist.add(plusProduct);	
			}
			System.out.println("DAO 추가상품 리스트 : " + plist);
						
			
			// hashMap에 담기 -----------------------------
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

	
	 /* 상품 업데이트 */ 
	public int updateThumbnailContent(Connection con, Product product, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateProduct");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getProductCategory());
			pstmt.setString(3, product.getProductItem());
			pstmt.setInt(4, product.getProductItemPrice());
			pstmt.setString(5, product.getProductContext());
			pstmt.setInt(6, num);
			
			System.out.println("---------------------------------");
			System.out.println("getProductName: "+product.getProductName());
			System.out.println("getProductCategory: "+product.getProductCategory());
			System.out.println("getProductItem: "+product.getProductItem());
			System.out.println("getProductItemPrice: "+product.getProductItemPrice());
			System.out.println("getProductContext: "+product.getProductContext());
			System.out.println("getProductNo: "+product.getProductNo());
			System.out.println("---------------------------------");
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		// 화면이 넘어가지 않는 문제 (result는 1증가)
		System.out.println("result(updateThumbnailContent) 업데이트 확인 : "+result);
		return result;
	}

	
	 /* 상품 업데이트 - 이미지 */ 
	public int updateAttachment(Connection con, ArrayList<Attachment> fileList, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("updateAttachment");
		
		
		try {
			for(int i=0; i<fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2, fileList.get(i).getChangeName());
				pstmt.setString(3, fileList.get(i).getImgFilePath());
				pstmt.setInt(4, num);
				pstmt.setInt(5, fileList.get(i).getImgNo());

				System.out.println("-----------------------------");
				System.out.println("getOriginName() updateAttachment Dao 이미지(ORIGIN) : "+fileList.get(i).getOriginName());
				System.out.println("getChangeName() updateAttachment Dao 이미지(CHANGE) : "+fileList.get(i).getChangeName());
				//System.out.println("getImgFilePath() updateAttachment Dao 이미지 : "+fileList.get(i).getImgFilePath());
				System.out.println("num updateAttachment Dao 이미지 : "+num);
				System.out.println("getImgNo() updateAttachment Dao 이미지번호 : "+fileList.get(i).getImgNo());
				System.out.println("-----------------------------");
				
				result += pstmt.executeUpdate(); // 누적 연산으로 합쳐준다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("updateAttachment(result값): "+result);
		
		return result;
	}


	 /* 상품 업데이트 - 추가 상품 */ 
	public int updatePlusProduct(Connection con, ArrayList<PlusProduct> pList, int num, ArrayList<String> plusList, ArrayList<PlusProduct> fixedpList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePlusProduct");
				
		try {
			for(int i=0; i<pList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, pList.get(i).getPlusProductItem());
				pstmt.setInt(2, pList.get(i).getPlusProductPrice());
				pstmt.setInt(3, num);
				if(i<fixedpList.size())
					pstmt.setString(4, fixedpList.get(i).getPlusProductItem());
				
				System.out.println("-----------------------------");
				System.out.println("getPlusProductItem: "+pList.get(i).getPlusProductItem());
				System.out.println("getPlusProductPrice: "+pList.get(i).getPlusProductPrice());
				System.out.println("getPlusProductItem(fixedpList): "+fixedpList.get(i).getPlusProductItem());
				System.out.println("num: "+num);
				System.out.println("-----------------------------");
				
				result += pstmt.executeUpdate(); // 누적 연산으로 합쳐준다
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("plusProduct.size(크기확인..): "+pList.size());
		System.out.println("plusProduct에 값이 들어오는지.. : "+pList);
		System.out.println("updatePlusProduct(result값): "+result);
		return result;
	}


	/* ajax를 이용한 검색(검색어 입력 후 검색버튼 클릭 시) */
	public ArrayList<HashMap<String, Object>> searchtList(Connection con, int currentPage, int listCount, int limit, String searchList) {
		PreparedStatement pstmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;

		String query = prop.getProperty("searchList");
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; // 조회할 때 시작할 행 번호
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, searchList); // jsp에서 검색한 단어 
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>(); // 맴버 객체 대신 hashmap 사용 / Object: 다형성,autoBoxing 처리
				
				hmap.put("imgNo", rset.getInt("IMG_NO")); // 오토박싱 처리로 코드를 줄일 수 있다. 
				hmap.put("originName", rset.getString("ORIGINNAME"));
				hmap.put("changeName", rset.getString("CHANGENAME"));
				hmap.put("imgCategoy", rset.getInt("IMG_CATEGORY"));
				hmap.put("memberCode", rset.getInt("MEMBER_CODE"));
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
				
				hmap.put("listCount", listCount);
				/*hmap.put("maxPage", maxPage);
				hmap.put("startPage", startPage);
				hmap.put("endPage", endPage);*/
				
				list.add(hmap);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 자원반납
			close(pstmt);
			close(rset);
		}
		System.out.println("이미지 리스트(검색어: "+searchList+" ): "+list);
		return list;
	}


	/* 상품 삭제(update PRODUCT_DELETEYN=1) */
	public int deleteOne(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("result(deleteOne) Dao 업데이트 확인 : "+result);
		return result;
	}
	

	/* 상품 삭제(update IMG_DELETE=1) */
	public int deleteImgOne(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteImgOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("result(deleteImgOne) Dao 업데이트 확인 : "+result);
		return result;
	}

	
	/* 특정 게시글 수 조회 */
	public int getTitleListCount(Connection con, String searchList) {
		PreparedStatement pstmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCountTitle");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchList);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		System.out.println("listCount(특정 게시물 수) : "+listCount);
		return listCount;
	}

	
	/* plusProduct 테이블의 item을 저장하기 위해 조회가 필요 */
/*	public int selectPlusProduct(Connection con) {
		Statement stmt = null;
		int result = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectPlusProduct");
		
		try {
			stmt = con.createStatement();			
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				listCount = rset.getInt(1);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		System.out.println("listCount(게시물 총 개수) : "+listCount);
		return result;
	}*/

	

}
